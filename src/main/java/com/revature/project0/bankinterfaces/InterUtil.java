package com.revature.project0.bankinterfaces;

import com.revature.project0.models.User;

/*
 * I still need a loop method. Needs to check input with scanner class somehow
 * */

public interface InterUtil {
	
	//Use the DAO method "get all usernames for this  one
	String checkForSameUsername(String Username);
	
	//checks if value is in range for welcome menu
	boolean validWelcomeMenuInt(int menuInput);
	
	//checks if value is in range for customer menu
	boolean validCustomerMenuInt(int menuInput);
	
	//checks if value is in range for employee menu
	boolean validEmployeeMenuInt(int menuInput);
	
	//checks if value is in range for admin menu
	boolean validAdminMenuInt(int menuInput);
	
	//for account model 
	long generateAccountNumber();
	
	//for account model
	long generateRoutingNumber();
	
	// this will login user on console, incorporate with loop somehow
	User login();
	
	// this will register user on console, incorporate with loop somehow
	User register();
	
	// need to figure out how to validate number inputs from user.
	void menuLoop();
	
	//shows general account info on login. Basically return the account toString method
	String showAccountInfo(User userId);

}