package com.revature.project0.bankinterfaces;

import java.util.Scanner;

public interface InterUtil {
	
	//checks if value is in range for welcome menu
	boolean validWelcomeMenuInt(int menuInput);
	
	//checks if value is in range for customer menu
	boolean validCustomerMenuInt(int menuInput);
	
	//checks if value is in range for employee menu
	boolean validEmployeeMenuInt(int menuInput);
	
	//checks if value is in range for admin menu
	boolean validAdminMenuInt(int menuInput);
	
	//This needs to go in the DAO
	String checkForSameUsername(String Username);
	
	double getInitialDeposit();
	
	String registerUsername();
	
	String registerPassword();
	
	//use this whenever I need to know if the customer/employee/admin is accessing an account, return string
	String checkUser();
	
	
	//This was asking for an input twice for some reason
//	int inputLoop(Scanner menuInput);

}