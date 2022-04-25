package com.revature.project0.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.User;

public interface UserDAO {

	public int createUser(User newUser);
	
	public User getUserById(int userId);
	
	public User getUserByUsername(String username);
	
	public User getUserByAccountId(int accountId);
	
	public ArrayList<User> getAllUsers();
	
	public ArrayList<String> getAllUsernames();

	public void updateUser(User currentUser);
	
	public void deleteUserById(User currentUser);
	
	
}
