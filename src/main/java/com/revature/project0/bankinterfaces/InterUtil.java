package com.revature.project0.bankinterfaces;

import com.revature.project0.models.User;

/*
 * I still need a loop method. Needs to check input with scanner class somehow
 * */

public interface InterUtil {
	
	//Use the DAO method "get all usernames" for this one and just see if it contains the newly created username
	String checkForSameUsername(String Username);
	
	/*
	 * The following 4 methods will be menu loops to validate input from human
	 * Needs to check for "exit" keyword, and return the appropriate int value.
	 * Loops if there isn't a valid input (alpha characters, negative numbers, etc.
	 * https://kodejava.org/how-do-i-validate-input-when-using-scanner/#:~:text=To%20validate%20input%20the%20Scanner,provide%20a%20positive%20integer%20number.
	 * */
	int validWelcomeMenuInput();
	
	//checks if value is in range for customer menu
	int validCustomerMenuInput();
	
	//checks if value is in range for employee menu
	int validEmployeeMenuInput();
	
	//checks if value is in range for admin menu
	int validAdminMenuInput();
	
	//for account model 
	long generateAccountNumber();
	
	//for account model
	long generateRoutingNumber();
	
	// this will login user on console, incorporate with loop somehow
	User login();
	
	// this will register user on console, incorporate with loop somehow
	User register();
	
	//shows general account info on login. Basically return the account toString method
	String showAccountInfo(User userId);

}