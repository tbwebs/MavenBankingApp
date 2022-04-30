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
//		
//		Role customer = new Role(1, "customer");
//		Role employee = new Role(2, "employee");
//		Role admin = new Role(3, "admin");
//		
//		Type personal = new Type(1, "personal");
//		Type joint = new Type(2, "joint");
//		
//		Status pending = new Status(1, "pending");
//		Status open = new Status(2, "open");
//		Status closed = new Status(3, "closed");
//		
//		User chloeTest = new User(1, "TEST chloe", "griffith", "cg@gmail.com", "pass", customer);
//		User victorTest = new User(2, "TEST vic", "griffin", "vg@gmail.com", "vpass", customer);
//		User treyTest = new User(3, "TEST trey", "web", "tb@gmail.com", "tpass", customer);
//	
//		long acctNum = utility.generateAccountNumber();
//		long routNum = utility.generateRoutingNumber();
//		
//		long acctNum1 = utility.generateAccountNumber();
//		long routNum1 = utility.generateRoutingNumber();
//		
//		Account account1 = new Account(1, acctNum, routNum, 100.00, personal, pending);
//		Account account2 = new Account(2, acctNum1, routNum1, 22, joint , open);
//		
//		AccountsUsers account1link = new AccountsUsers(1, chloeTest.getUserId(), account1.getAccountId());
//		AccountsUsers account2jointlink = new AccountsUsers(2, victorTest.getUserId(), account2.getAccountId());
//		AccountsUsers account2jointlink1 = new AccountsUsers(3, treyTest.getUserId(), account2.getAccountId());
		
		System.out.println(Janus.janusGreeting());
		
		int userCount = 0;
		int accountCount = 0;
		int linkCount = 0;
		
		ArrayList<String> credentials;
		
		int menuSelection;
		User currentUser;
		
		menuSelection = utility.validWelcomeMenuInput();
		
		if (menuSelection == 0) {
			
			System.out.println(Janus.farewell());
			
		} else if (menuSelection == 1) {
			
			/*
			 * This is when the user is logging in. need to refactor to a menu method so I can recursively call this.
			 * */
			
			credentials = utility.login();
			
			while (!userDAO.doesUserExist(credentials.get(0), credentials.get(1))) {
				
				System.out.println("The username/password was invalid. Try Again");
				credentials = utility.login();
				
				if (userDAO.doesUserExist(credentials.get(0), credentials.get(1)))
					break;
					
				if (credentials.get(0) == "0")
					break;
					
			}
			
			/*
			 * here I'm checking for role to determine which menus and options to display for user.
			 * Keep working in driver to see if it works then refactor each part to make menu methods that I can call.
			 *
			 * */
			
			currentUser = userDAO.getUserByUsername(credentials.get(0));
			
			int currentUserRole = userDAO.getUserByUsername(credentials.get(0)).getRole().getRoleId();
			
			//customer
			if (currentUserRole == 1) {
				
				System.out.print(Janus.customerGreeting());
				
				// will need this for any of the transactions
				ArrayList<Account> currentAccounts = accountDAO.getAccountsbyUserId(currentUser.getUserId());
				
				utility.customerMenu(currentUser, currentAccounts);
			
			// employee
			} else if (currentUserRole == 2) {
				
				//this should be easy, they can only view and approve accounts. Already refactered toString methods
				System.out.print(Janus.employeeGreeting());
				int employeeMenuInput = utility.validEmployeeMenuInput();
				
			// admin
			} else {
				
				// This could take a while but most logic should be figured  out by now.
				
				System.out.print(Janus.adminGreeting());
				int adminMenuInput = utility.validAdminMenuInput();
				
			}
			
		
		} else {
			
			/*
			 * This is when there is a new user and need they are registered. They will only be able to view
			 * their account until an employee changes their status to "open".
			 * Exit them out of this and make them login again so they can go through the logic above.
			 * 
			 * need to check for user role here too to determine if I need to make a AccountUser link.
			 * */
		
			currentUser = utility.registerUser(userCount);
			userCount = userDAO.createUser(currentUser);
			
			Account newAccount = utility.registerAccount(accountCount, userCount);
			accountCount = accountDAO.createAccount(newAccount);
			
		}
		
	}
}
