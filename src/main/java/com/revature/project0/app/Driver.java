package com.revature.project0.app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.AccountsUsersDAO;
import com.revature.project0.daos.AccountsUsersDAOImpl;
import com.revature.project0.daos.RoleDAOImpl;
import com.revature.project0.daos.StatusDAOImpl;
import com.revature.project0.daos.TypeDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.AccountsUsers;
import com.revature.project0.models.Role;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.models.User;
import com.revature.project0.utilclasses.Janus;
import com.revature.project0.utilclasses.Menus;
import com.revature.project0.utilclasses.ProjectUtil;

public class Driver {
		
	public static void main(String[] args) {

		//DAOS
		RoleDAOImpl roleDAO = new RoleDAOImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
		TypeDAOImpl typeDAO = new TypeDAOImpl();
		StatusDAOImpl statusDAO = new StatusDAOImpl();
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		AccountsUsersDAOImpl linkDAO = new AccountsUsersDAOImpl();
		ProjectUtil utility = new ProjectUtil();
		Menus menus = new Menus();
		
		//Variables for log in
		ArrayList<String> credentials;
		User currentUser;

		System.out.print(Janus.janusGreeting());
		
		//controls main driver loop. REMOVE IF you are  getting weird infinite loops.
		boolean run = true;
		
		int menuSelection;
		
		do {
			//checks for valid number input. Options are for logging in, registering, or quitting the app.
			menuSelection = utility.validWelcomeMenuInput();
			
			switch (menuSelection) {
				
				//user chose to exit app.
				case 0:
					
					System.out.println(Janus.farewell());
					run = false;
					break;
				
				//user is logging in
				case 1:
					
					//this holds the username and password of user, login() method checks if user exists in database
					credentials = utility.login(userDAO);
					
					//checks if user wants to exit
					if (credentials.contains("0"))
						break;
					
					//grabs current user from
					currentUser = userDAO.getUserByUsername(credentials.get(0));
					
					//checks for role for appropriate menu below
					int currentUserRole = userDAO.getUserByUsername(credentials.get(0)).getRole().getRoleId();
					
					//customer option
					if (currentUserRole == 1) {
						
						System.out.print(Janus.customerGreeting());
						
						//loop method implementing customers options with their account
						menus.customerMenu(currentUser, accountDAO, userDAO, linkDAO);
						
					//employee option
					} else if (currentUserRole == 2) {
						
						System.out.print(Janus.employeeGreeting());
						
						//gets users and accounts list for employee menu
						ArrayList<Account> allAccounts = accountDAO.getAllAccounts();
						ArrayList<User> allUsers = userDAO.getAllUsers();
						
						//loop method implementing employee options with their account
						menus.employeeMenu(currentUser, allAccounts, allUsers, accountDAO, userDAO);
						
					//admin option
					} else if (currentUserRole == 3) {
						
						System.out.print(Janus.adminGreeting());
						
						ArrayList<Account> allAccounts = accountDAO.getAllAccounts();
						ArrayList<User> allUsers = userDAO.getAllUsers();
						
						//loop method implementing admin options with their account
						menus.adminMenu(currentUser, allAccounts, allUsers, accountDAO, userDAO);
						
					} else {
						
						//control statement
						continue;
					}
					break;
					
				// register new user. Logs user out once account is created. If it's a customer they will make an account before logging out
				case 2:
					
					//creates new user
					currentUser = utility.registerUser(userDAO);
					userDAO.createUser(currentUser);
					
					//checks if user is a customer
					if (currentUser.getRole().getRoleId() == 1) {
						
						//creates account with associated user
						Account newAccount = utility.registerAccount(currentUser, accountDAO, userDAO, linkDAO);
					}
					
					System.out.println(Janus.successfulRegistration());
					break;
				
			}
			
			//checks for run variable so can break out of loop
			if (!run)
				break;
			
		} while (run);
		
	}
}
