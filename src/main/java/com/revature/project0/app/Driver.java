package com.revature.project0.app;

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

//		RoleDAOImpl roleDAO = new RoleDAOImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
//		TypeDAOImpl typeDAO = new TypeDAOImpl();
//		StatusDAOImpl statusDAO = new StatusDAOImpl();
//		AccountDAOImpl accountDAO = new AccountDAOImpl();
//		AccountsUsersDAOImpl linkDAO = new AccountsUsersDAOImpl();
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
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Janus.janusGreeting());
		
		User currentUser;
		ArrayList<Account> currentAccounts;
		int userCount = 1;
		int menuInput;
			
		menuInput = utility.validWelcomeMenuInput();
		
		switch (menuInput) {
	
			case 0:
				
				System.out.print(Janus.farewell());
				break;
				
			case 1:
				
				ArrayList<User> users = userDAO.getAllUsers();
				ArrayList<String> credentials;
				
				credentials = utility.login();
				
				break;
	
			case 2:
				
				String firstName;
				String lastName;
				String email;
				String password;
				int roleSelection;
				String typeSelection;
				
				System.out.println(Janus.usernameNotice());
				System.out.print("Enter your first name: ");
				firstName = sc.next();
				System.out.print("Enter your last name: ");
				lastName = sc.next();
				System.out.print("Enter your email: ");
				email = sc.next();
				System.out.print("Enter your password");
				password = sc.next();
				System.out.print("What is your role with Revature Financial?\n"
						+ "1 : New customer\n"
						+ "2 : New employee\n"
						+ "3 : New admin\n"
						+ "Input: ");
				roleSelection = sc.nextInt();
				
				if (roleSelection == 1) {
					
					System.out.print("Is this a joint account? y/n\n"
						+ "Input: ");
					typeSelection = sc.next();
					
					switch (typeSelection) {
					
					case "y":
						System.out.print("Enter additional customer's first name: ");
						String secondFirstName = sc.next();
						System.out.print("Enter additional customer's last name: ");
						String secondLastName = sc.next();
						System.out.print("Enter additional customer's email: ");
						String secondEmail = sc.next();
						System.out.print("Enter additional customer's password");
						String secondPassword = sc.next();
						
						currentUser = new User(userCount, firstName, lastName, email, password, new Role(1, "customer"));
						userCount = userDAO.createUser(currentUser);
						User jointUser = new User(userCount, secondFirstName, secondLastName, secondEmail, secondPassword, new Role(1, "customer"));
						userCount = userDAO.createUser(jointUser);
						break;
						
					case "n":
						currentUser = new User(userCount, firstName, lastName, email, password, new Role(1, "customer"));
						userCount = userDAO.createUser(currentUser);
						break;
					}
				
				} else if (roleSelection == 2 ) {
					
					currentUser = new User(userCount, firstName, lastName, email, password, new Role(2, "employee"));
					userCount = userDAO.createUser(currentUser);
					
				} else {
					
					currentUser = new User(userCount, firstName, lastName, email, password, new Role(3, "admin"));
					userCount = userDAO.createUser(currentUser);
				}
				
				System.out.print(Janus.initialDepositNotice());
				double initialDeposit = sc.nextDouble();
				
				
				
				
				break;

			
		}
		
		
	}
}
