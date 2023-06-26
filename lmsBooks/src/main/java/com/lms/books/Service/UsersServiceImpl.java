package com.lms.books.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.books.Model.Users;
import com.lms.books.Repository.UsersRepository;

import jakarta.transaction.Transactional;
import net.minidev.json.JSONObject;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public ResponseEntity<?> validateUser(Users user) {
		// TODO Auto-generated method stub
		var findUser = usersRepository.findById(user.getUserEmail());
		try {
			if(findUser.isPresent()) {
				if(user.getRole().equals(findUser.get().getRole())) {
					if(user.getPassword().equals(findUser.get().getPassword())) {
						JSONObject obj = new JSONObject();
						obj.put("userEmail", findUser.get().getUserEmail());
						obj.put("role", findUser.get().getRole());
						obj.put("message", "Login Successful");
						return new ResponseEntity<>(obj, HttpStatus.OK);
					}
					else {
						throw new Exception("Password is incorrect");
					}
				}
				else {
					throw new Exception("Please select correct type of User");
				}
			}
			else {
				throw new Exception("No such account exist");
			}
		}
		catch(Exception ex){
			JSONObject obj = new JSONObject();
			obj.put("error", ex.getMessage());
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
	}

	@Override
	public ResponseEntity<?> createUser(Users user) {
		var findUser = usersRepository.findById(user.getUserEmail());
		try {
			if(findUser.isPresent()) {
				throw new Exception("Account already exists");
			}
			else {
				usersRepository.save(user);
				JSONObject obj = new JSONObject();
				obj.put("userEmail", user.getUserEmail());
				obj.put("message", "User Created");
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
		}
		catch(Exception ex) {
			JSONObject obj = new JSONObject();
			obj.put("error", ex.getMessage());
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
	}

	@Override
	public ResponseEntity<?> updateUser(Users user) {
		// TODO Auto-generated method stub
		var findUser = usersRepository.findById(user.getUserEmail());
		try {
			if(findUser.isPresent()) {
				usersRepository.save(user);
				JSONObject obj = new JSONObject();
				obj.put("userEmail", user.getUserEmail());
				obj.put("password", user.getPassword());
				obj.put("message", "User Updated");
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else {				
				throw new Exception("Account does not exist");
			}
		}
		catch(Exception ex) {
			JSONObject obj = new JSONObject();
			obj.put("error", ex.getMessage());
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
	}

	@Override
	public ResponseEntity<?> deleteUser(JSONObject user) {
		// TODO Auto-generated method stub
		System.out.println(user);
		String userEmail = user.getAsString("userEmail");
		System.out.println(userEmail);
		var findUser = usersRepository.findById(userEmail);
		try {
			if(findUser.isPresent()) {
				usersRepository.deleteById(userEmail);
				JSONObject obj = new JSONObject();
				obj.put("message", "User Deleted");
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else {
				throw new Exception("Account does not exist");
			}
		}
		catch(Exception ex) {
			JSONObject obj = new JSONObject();
			obj.put("error", ex.getMessage());
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
	}

	@Override
	public ResponseEntity<?> getUsers() {
		// TODO Auto-generated method stub
		List<Users> users = (List<Users>) usersRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
}
