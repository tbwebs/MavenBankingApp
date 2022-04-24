package com.revature.project0.app;

import java.util.*;

import com.revature.project0.utilclasses.Janus;
import com.revature.project0.utilclasses.ProjectUtil;

public class Driver {
		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ProjectUtil pUtil = new ProjectUtil();
		
		//TODO use getValidInput() method in util
		// think about using abstractiion with the customer/employee/admin/account classes considering the sensitive data.
		
			
		System.out.print(Janus.welcomeMenu());
		int menuInput = 0;
		
		//Need to make a loop to handle string inputs but accept integers he
	
		 
		if (pUtil.validWelcomeMenuInt(menuInput)) {
			
			switch (menuInput){
			
			case 1 : 
			
				System.out.print("Username: ");
				String userName = sc.next();
				
				System.out.print("Password: ");
				String password = sc.next();
			
			case 2 :
				
				System.out.print("First Name: ");
				String firstName = sc.next();
				
				System.out.print("Last Name: ");
				String lastname = sc.next();
				
			}
		}
	}
}
