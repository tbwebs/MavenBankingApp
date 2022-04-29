package com.revature.project0.utilclasses;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.project0.bankinterfaces.InterUtil;
import com.revature.project0.models.Account;
import com.revature.project0.models.Role;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.models.User;

//Where all my helper methods are
public class ProjectUtil implements InterUtil {
	
	@Override
	public ArrayList<String> login() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your username: ");
		String username = sc.next();
		
		System.out.print("Enter your password: ");
		String password = sc.next();
		
		ArrayList<String> credentials = new ArrayList<String>();
		
		credentials.add(username);
		credentials.add(password);
		
		return credentials;
	}
	
	@Override
	public User registerUser(int userCount) {
		
		User currentUser = new User();
		Role currentRole = new Role();
		String firstName;
		String lastName;
		String username;
		String email;
		String password;
		int roleSelection;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("Enter your first name: ");
			firstName = sc.next();
			System.out.print("Enter your last name: ");
			lastName = sc.next();
			System.out.print("Enter a username: ");
			username = sc.next();
			System.out.print("Enter your email: ");
			email = sc.next();
			System.out.print("Enter your password: ");
			password = sc.next();
			System.out.print("What is your role with Revature Financial?\n"
					+ "1 : New customer\n"
					+ "2 : New employee\n"
					+ "3 : New admin\n"
					+ "Input: ");
			roleSelection = sc.nextInt();
			
			if (roleSelection == 1) {
				
				currentRole.setRoleId(1);
				currentRole.setRole("customer");
				
			} else if (roleSelection == 2) {
				
				currentRole.setRoleId(2);
				currentRole.setRole("employee");
				
			} else {
				
				currentRole.setRoleId(3);
				currentRole.setRole("admin");
			}
			
			currentUser.setUserId(userCount);
			currentUser.setFirstName(firstName);
			currentUser.setLastName(lastName);
			currentUser.setUsername(username);
			currentUser.setEmail(email);
			currentUser.setPassword(password);
			currentUser.setRole(currentRole);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return currentUser;
	}

	@Override
	public Account registerAccount(int accountCount, int userCount) {
		
		Account currentAccount = new Account();
		Type currentType = new Type();
		Status pendingStatus = new Status(1, "pending");
		long newAccountNum = this.generateAccountNumber();
		long newRoutingNum = this.generateRoutingNumber();
		double initialDeposit;
		int typeSelection;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("What kind of account do you want to open?\n"
					+ "1 : personal\n"
					+ "2 : joint\n"
					+ "Input: ");
			typeSelection = sc.nextInt();
			
			if (typeSelection == 1) {
				
				currentType.setTypeId(1);
				currentType.setType("personal");
				
			} else {
				
				System.out.println("Please register the second account holder.");
				User secondUser = this.registerUser(userCount);
				currentType.setTypeId(2);
				currentType.setType("joint");
				
			}
			
			System.out.print(Janus.initialDepositNotice());
			
			initialDeposit = sc.nextDouble();
	
			currentAccount.setAccountId(accountCount);
			currentAccount.setAccountNumber(newAccountNum);
			currentAccount.setRoutingNumber(newRoutingNum);
			currentAccount.setBalance(initialDeposit);
			currentAccount.setType(currentType);
			currentAccount.setStatus(pendingStatus);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return currentAccount;
	}
	
	public long generateAccountNumber() {
		
		int min = 1;
		long max = 10000000000000000L;
		
		long randomNumber = (long) Math.floor(Math.random()*(max-min+1)+min);
		
		return randomNumber;
	}
	
	// formula from <https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java>
	// 9 digits
	public long generateRoutingNumber() {
		
		int min = 1;
		long max = 100000000L;
		
		long randomNumber = (long) Math.floor(Math.random()*(max-min+1)+min);
		
		return randomNumber;
		
	}
	
	public int generateRandomNumber() {
		
		int min = 10;
		int max = 99;
		
		int randomNumber = (int) Math.floor(Math.random()*(max-min+1)+min);
		return randomNumber;
	}
	
	//This will update the amount of users there are for new primary key entries
	public int updateUserCount(int userCount) {
		
		userCount += 1;
		return userCount;
	}
	
	//This will update the amount of accounts there are for new primary key entries
	public static int updateAccountCount(int accountCount) {
		
		accountCount += 1;
		return accountCount;
	}
	
	//This will update the amount of links for new link primary keys. This value will probably be higher than the others.
	public static int updateLinkCount(int linkCount) {
		
		linkCount += 1;
		return linkCount;
	}


	@Override
	public String showAccountInfo(User currentUser) {
		
		return null;
	}
	

	/*
	 * The following 4 methods will be menu loops to validate input from human
	 * Return 0 for "exit" keyword, otherwise need to return appropriate menu number.
	 * Loops if there isn't a valid input (alpha characters, negative numbers, etc.
	 * https://kodejava.org/how-do-i-validate-input-when-using-scanner/#:~:text=To%20validate%20input%20the%20Scanner,provide%20a%20positive%20integer%20number.
	 * */
	@Override
	public int validWelcomeMenuInput() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			
			System.out.print(Janus.welcomeMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println(Janus.welcomeOops());
				System.out.print(Janus.welcomeMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 2) {
				
				System.out.println(Janus.welcomeOops());
				
			} else if (numInput < 0) {
				
				System.out.println(Janus.welcomeOops());
				
			} else {
				
				continue;
			}
			
		} while (numInput < 0|| numInput > 2);
		
		return numInput;
		
	}

	@Override
	public int validCustomerMenuInput() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			
			System.out.print(Janus.customerMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println(Janus.customerOops());
				System.out.print(Janus.customerMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 6) {
				
				System.out.println(Janus.customerOops());
				
			} else if (numInput < 0) {
				
				System.out.println(Janus.customerOops());
				
			} else {
				
				continue;
			}
			
		} while (numInput < 0|| numInput > 6);
		
		return numInput;
	}

	@Override
	public int validEmployeeMenuInput() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			
			System.out.print(Janus.employeeMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println(Janus.employeeOops());
				System.out.print(Janus.employeeMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 4) {
				
				System.out.println(Janus.employeeOops());
				
			} else if (numInput < 0) {
				
				System.out.println(Janus.employeeOops());
				
			} else {
				
				continue;
			}
			
		} while (numInput < 0|| numInput > 4);
		
		return numInput;

	}

	@Override
	public int validAdminMenuInput() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			
			System.out.print(Janus.adminMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println(Janus.adminOops());
				System.out.print(Janus.adminMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 8) {
				
				System.out.println(Janus.adminOops());
				
			} else if (numInput < 0) {
				
				System.out.println(Janus.adminOops());
				
			} else {
				
				continue;
			}
			
		} while (numInput < 0|| numInput > 8);
		
		return numInput;
	}
	
	@Override
	public boolean checkForSameUsername(ArrayList<String> usernameList, String username) {
		
		return usernameList.contains(username);
	}

	
}
