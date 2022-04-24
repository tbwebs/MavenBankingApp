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

	@Override
	public User login() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User register() {
		// TODO Auto-generated method stub
		return null;
	}

	
	//This catches InputMismatchException for menu selection screen
//	@Override
//	public int inputLoop(Scanner input) {
//		
//		int inputNum = 0;
//		boolean loop = true;
//		
//		 while (loop) {
//	    	
//	        if (input.hasNextInt()) {
//	        	
//	        	System.out.print("Input: ");
//	            inputNum = sc.nextInt();
//	        
//	        } else {
//	        	
//	        	System.out.println(Janus.welcomeOops());
//	        	System.out.print("Input: ");
//	            sc.next();
//	            continue;
//	            
//	        }
//	        loop = false;
//		 }
//		
//		return inputNum;
//	}
	
}
