package com.revature.project0.daos;

import java.util.List;

import com.revature.project0.models.User;

public interface UserDAO {

	public void createUser(User newUser);
	
	public User getUserById(int userId);
	
	public User getUserByUsername(String username);
	
	public User getUserByAccountId(int accountId);
	
	public List<User> getAllUsers();

	public void updateUser(User currentUser);
	
	public void deleteUserById(User currentUser);
	
	
}
