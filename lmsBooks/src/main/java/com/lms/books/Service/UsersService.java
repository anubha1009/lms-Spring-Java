package com.lms.books.Service;

import org.springframework.http.ResponseEntity;

import com.lms.books.Model.Users;

import net.minidev.json.JSONObject;

public interface UsersService {
	public ResponseEntity<?> validateUser(Users user);
	
	public ResponseEntity<?> createUser(Users user);
	
	public ResponseEntity<?> updateUser(Users user);
	
	public ResponseEntity<?> deleteUser(JSONObject user);
	
	public ResponseEntity<?> getUsers();
	
}
