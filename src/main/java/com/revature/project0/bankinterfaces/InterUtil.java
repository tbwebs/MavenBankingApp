package com.revature.project0.bankinterfaces;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.User;

/*
 * I still need a loop method. Needs to check input with scanner class somehow
 * */

public interface InterUtil {
	
	//validates menu input
	int validWelcomeMenuInput();
	
	//validates menu input
	int validCustomerMenuInput();
	
	//validates menu input
	int validEmployeeMenuInput();
	
	//validates menu input
	int validAdminMenuInput();
	
	//for account model 
	long generateAccountNumber();
	
	//for account model
	long generateRoutingNumber();
	
	//for username creation
	int generateRandomNumber();
	
	// this will login user on console, incorporate with loop somehow
	ArrayList<String> login();
	
	// this will register user on console, incorporate with loop somehow
	User register();
	
	//shows general account info on login. Basically return the account toString method
	String showAccountInfo(User currentUser);
	
	boolean checkForSameUsername(ArrayList<String> usernameList, String username);
	
	boolean checkUsernamePassword(ArrayList<User> usersList, String username, String password);


}