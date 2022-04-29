package com.revature.project0.models;

//This class will model user database. role will be customer/employee/admin.
public class User {
	
	private int userId;
	private String firstName, lastName, username, password, email;
	private Role role;
	
	public User() { super(); }
	
	public User(int userId, String firstName, String lastName, String username, String email, String password, Role role) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int newUserId) {
		this.userId = newUserId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String newLastName) {
		 this.firstName = newLastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String newLastName) {
		 this.lastName = newLastName;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public String getPassword () {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setRole(Role newRole) {
		this.role = newRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

	
	
	
}
