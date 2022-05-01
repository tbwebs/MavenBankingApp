package com.revature.project0.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.User;

public interface UserDAO {

	public void createUser(User newUser);
	
	public User getUserByUsername(String username);
	
	public ArrayList<User> getUsersByAccountNumber(long accountNumber);
	
	public ArrayList<User> getAllUsers();
	
	public ArrayList<String> getAllUsernames();

	public void updateUser(User currentUser);
	
	public void deleteUserByUsername(String username);
	
	//for login
	public boolean doesUserExist(String username, String password);
	
}
