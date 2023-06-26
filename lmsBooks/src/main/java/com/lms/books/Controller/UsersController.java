package com.lms.books.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.books.Model.Users;
import com.lms.books.Service.UsersService;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin(origins = "*")
public class UsersController {
	@Autowired
	private UsersService usersService;
	@CrossOrigin(origins = "*")
	
	@PostMapping("/login")
	private ResponseEntity<?> validateUser(@RequestBody Users user) {
		return usersService.validateUser(user);
	}
	
	@PostMapping("/createUser")
	private ResponseEntity<?> createUser(@RequestBody Users user){
		return usersService.createUser(user);
	}
	
	@PutMapping("/updateUser")
	private ResponseEntity<?> updateUser(@RequestBody Users user){
		return usersService.updateUser(user);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteUser")
	private ResponseEntity<?> deleteUser(@RequestBody JSONObject user){
		return usersService.deleteUser(user);
	}
	
	@GetMapping("/getUsers")
	private ResponseEntity<?> getUsers(){
		return usersService.getUsers();
	}
}
