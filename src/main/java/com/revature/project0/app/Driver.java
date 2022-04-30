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
		
		int userId = 0;
		
		ArrayList<String> credentials;
		
		int menuSelection;
		User currentUser;
		Account newAccount;
		ArrayList<User> userList = userDAO.getAllUsers();
		
		menuSelection = utility.validWelcomeMenuInput();
		
		if (menuSelection == 0) {
			
			System.out.println(Janus.farewell());
			
		} else if (menuSelection == 1) {
			
			credentials = utility.login();
			
			if (userDAO.doesUserExist(credentials.get(0), credentials.get(1))) {
				
				currentUser = userDAO.getUserByUsername(credentials.get(0));
			}
			else {
				
				System.out.println("The username/password was invalid. Try Again");
				credentials = utility.login();
			}
		
		} else {
		
			currentUser = utility.registerUser(userCount);
			userCount = userDAO.createUser(currentUser);
			
			newAccount = utility.registerAccount(accountCount, userCount);
			accountCount = accountDAO.createAccount(newAccount);
			
		}
		
		
		
		//check for role
			// if customer need to create new account link
		//show appropriate menu.
		//loop through  options until user exits
		
		
	}
}
