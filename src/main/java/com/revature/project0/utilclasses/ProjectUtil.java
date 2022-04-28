package com.revature.project0.utilclasses;

import java.util.Scanner;

import com.revature.project0.bankinterfaces.InterUtil;
import com.revature.project0.models.User;

//Where all my helper methods are
public class ProjectUtil implements InterUtil {
	
	Scanner sc = new Scanner(System.in);

	//This method needs to go in the DAO, or wherever the users are stored
	@Override
	public String checkForSameUsername(String Username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validWelcomeMenuInt(int menuInput) {
		if (menuInput > 0 && menuInput < 3) {
			return true;
		} else {
			
			System.out.println(Janus.welcomeOops());
			return false;
		}
	}

	@Override
	public boolean validCustomerMenuInt(int menuInput) {
		if (menuInput > 0 && menuInput < 7) {
			return true;
		} else {
			
			System.out.println(Janus.customerOops());
			return false;
		}
	}

	@Override
	public boolean validEmployeeMenuInt(int menuInput) {
		if (menuInput > 0 && menuInput < 5) {
			return true;
		} else {
			
			System.out.println(Janus.employeeOops());
			return false;
		}
	}

	@Override
	public boolean validAdminMenuInt(int menuInput) {
		if (menuInput > 0 && menuInput < 9) {
			return true;
		} else {
			
			System.out.println(Janus.adminOops());
			return false;
		}
	}

	//these methods may want to be in the driver class
	@Override
	public User login() {
		/*
		 * Step 1: Import scanner and get username/password
		 * Step 2: Check for username/password in database
		 * Step 3: if matches, show account info, and return user.
		 * Step 4: if does not match, loop back to step 1.
		 * */
		return null;
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
	public void menuLoop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String showAccountInfo(User userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
