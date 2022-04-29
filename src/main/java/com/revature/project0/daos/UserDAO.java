package com.revature.project0.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.User;

public interface UserDAO {

	public int createUser(User newUser);
	
	public User getUserById(int userId);
	
	public User getUserByUsername(String username);
	
	public ArrayList<User> getUsersByAccountId(int accountId);
	
	public ArrayList<User> getAllUsers();
	
	public ArrayList<String> getAllUsernames();

	public void updateUser(User currentUser);
	
	public void deleteUserById(int userId);
	
	//for login
	public boolean doesUserExist(String username, String password);
	
}
