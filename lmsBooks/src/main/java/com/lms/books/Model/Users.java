package com.lms.books.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	private String userEmail;
	private String password;
	private String role;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Users(String userEmail, String password, String role) {
		super();
		this.userEmail = userEmail;
		this.password = password;
		this.role = role;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [userEmail=" + userEmail + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
