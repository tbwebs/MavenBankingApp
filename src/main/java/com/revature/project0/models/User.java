package com.revature.project0.models;

//This class will model user database. role will be customer/employee/admin.
public class User {
	
	private String firstName, lastName, username, password, email;
	private Role role;
	
	public User() { super(); }
	
	public User(String username, String password, String firstName, String lastName, String email, Role role) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User : " + firstName + " " + lastName + "\nUsername : " + username + "\nEmail : " + email + "\nRole : " + role.getRole();
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

	
}
