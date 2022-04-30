package com.revature.project0.bankinterfaces;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.Role;
import com.revature.project0.models.User;

/*
 * I still need a loop method. Needs to check input with scanner class somehow
 * */

public interface InterUtil {
	
	ArrayList<String> login();
	
	//validates menu input
	int validWelcomeMenuInput();
	
	//validates menu input
	int validCustomerMenuInput();
	
	//validates menu input
	int validEmployeeMenuInput();
	
	//validates menu input
	int validAdminMenuInput();
	
	void customerMenu(User user, ArrayList<Account> accounts);
	
	void employeeMenu(ArrayList<Account> accounts);
	
	void adminMenu(User user, ArrayList<Account> accounts);
	
	int checkRole(Role role);
	
	//for account model 
	long generateAccountNumber();
	
	//for account model
	long generateRoutingNumber();
	
	//for username creation
	int generateRandomNumber();

	// creates new 
	User registerUser(int userCount);
	
	Account registerAccount(int accountCount, int userCount);
	
	//shows general account info on login. Basically return the account toString method
	String showAccountInfo(User currentUser);
	
	boolean checkForSameUsername(ArrayList<String> usernameList, String username);


}