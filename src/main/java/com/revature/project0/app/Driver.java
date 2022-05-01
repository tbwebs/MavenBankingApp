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

		RoleDAOImpl roleDAO = new RoleDAOImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
		TypeDAOImpl typeDAO = new TypeDAOImpl();
		StatusDAOImpl statusDAO = new StatusDAOImpl();
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		AccountsUsersDAOImpl linkDAO = new AccountsUsersDAOImpl();
		ProjectUtil utility = new ProjectUtil();
		Menus menus = new Menus();
		
		ArrayList<String> credentials;
		User currentUser;
		
			
		System.out.println(Janus.janusGreeting());
		
		//controls main driver loop. REMOVE IF you are  getting weird infinite loops.
		boolean run = true;
		int menuSelection;
		
		do {
			menuSelection = utility.validWelcomeMenuInput();
			
			switch (menuSelection) {
			
				case 0:
					
					System.out.println(Janus.farewell());
					run = false;
					break;
					
				case 1:
					/*
					 * here I'm checking for role to determine which menus and options to display for user.
					 * 
					 * Keep working in driver to see if it works then refactor each part to make menu methods that I can call.
					 *
					 * */
					credentials = utility.login(userDAO);
					
					if (credentials.contains("0"))
						break;
					
					currentUser = userDAO.getUserByUsername(credentials.get(0));
					
					int currentUserRole = userDAO.getUserByUsername(credentials.get(0)).getRole().getRoleId();
					
					//customer
					if (currentUserRole == 1) {
						
						System.out.println(Janus.customerGreeting());

						ArrayList<Account> currentAccounts = accountDAO.getAccountsbyUsername(currentUser.getUsername());
						
						menus.customerMenu(currentUser, currentAccounts, accountDAO, userDAO, linkDAO);
						
					} else if (currentUserRole == 2) {
						
						System.out.println(Janus.employeeGreeting());
						
						ArrayList<Account> allAccounts = accountDAO.getAllAccounts();
						
						ArrayList<User> allUsers = userDAO.getAllUsers();
						
						
					} else {
						
						//admin
					}
					break;
					
				case 2:
					
					/*
					 * This is when there is a new user and need they are registered.
					 * 
					 * Exit them out of this and make them login again so they can go through the logic above.
					 * 
					 * need to check for user role here too to determine if I need to make a AccountUser link.
					 * */
	
					currentUser = utility.registerUser(userDAO);
					userDAO.createUser(currentUser);
					
					if (currentUser.getRole().getRoleId() == 1) {
	
						Account newAccount = utility.registerAccount(userDAO, linkDAO);
						accountDAO.createAccount(newAccount);
						
						int linkid = linkDAO.getLinkCount();
						AccountsUsers newLink = new AccountsUsers(linkid + 1, currentUser.getUsername(), newAccount.getAccountNumber());
						
						linkDAO.createAccountsUsersLink(newLink);
					}
					
					System.out.println(Janus.successfulRegistration());
					break;
				
			}
			
			if (!run)
				break;
			
		} while (run);
		
	}
}
