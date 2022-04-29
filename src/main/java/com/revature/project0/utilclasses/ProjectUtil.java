package com.revature.project0.utilclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.project0.bankinterfaces.InterUtil;
import com.revature.project0.models.User;

//Where all my helper methods are
public class ProjectUtil implements InterUtil {

	@Override // just grab the info in the drive class in a loop so you can use the DAO methods
	public ArrayList<String> login() {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> credentials = new ArrayList<String>();
		String username;
		String password;
		
		System.out.print("Enter your username: ");
		username = sc.next();
		
		System.out.print("Enter your password: ");
		password = sc.next();
		
		credentials.add(username);
		credentials.add(password);
		
		return credentials;
	}
	
	//Maybe think about employees/admins also having accounts. Shouldn't change logic that much just the menus and options
	@Override
	public User register() {
		
		/*
		 * Step 1: Import Scanner
		 * Step 2: Get first,last name, password, email, role
		 * Step 3: Ask if it's a joint account, if so get same info for other person
		 * Step 4: Ask for initial deposit, and add joint user with their account
		 * Step 5: Tell them they don't have options until their account is approved, return user.
		 * */
		
		return null;
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

	@Override
	public boolean checkUsernamePassword(ArrayList<User> usersList, String username, String password){
		
		for (User i : usersList) {
			
			if (i.getUsername().equals(username) && i.getPassword().equals(password)){
				
				return true;
				
			} else {
				
				return false;
			}
		}
		return false;
	}
	
}
