package com.revature.project0.utilclasses;

// This is the class that will hold all menu selections and interact with the user on the console
public class Janus {
	
	public static String janusGreeting() {
		
		String menu = new String("Welcome human! My name is Janus, your digital assistant here at Revature Financial!\n\n"
				+ "You can enter \"0\" to go back a menu, or if your here you'll exit the application:\n");
		
		return menu;
	}
	
	public static String welcomeMenu() {
		
		String menu = new String("\n1 : Log In\n"
				+ "2 : Register\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String farewell() {
		
		String menu = "\nFarewell human, come back soon!";
		
		return menu;
	}
	
	public static String customerGreeting() {
		
		String menu = new String("\nGreetings human, it's Janus again! Consider your options below and don't try to\n"
				+ "outsmart me with those pesky alphebetical characters:\n");
		
		return menu;
	}
	
	public static String customerMenu() {
		
		String menu = new String("\n1 : View Account(s)\n"
				+ "2 : Deposit\n"
				+ "3 : Withdraw\n"
				+ "4 : Transfer\n"
				+ "5 : Open New Account\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String employeeGreeting() {
		
		String menu = new String("\nHey fellow employee, it's hard out here for a machine isn't it? Anyway...\n");
		
		return menu;
	}
	
	public static String employeeMenu() {
		
		String menu = new String("\n1 : Lookup User\n"
				+ "2 : Lookup Account\n"
				+ "3 : View Account Applications (all pending/closed accounts)\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String accountLookupMenu() {
		
		String menu = new String("How can I help narrow down your search?\n"
				+ "1 : Lookup by username\n"
				+ "2 : Lookup by account number\n"
				+ "3 : Lookup all accounts\n"
				+ "Input : ");
		
		return menu;
	}
	
	public static String adminGreeting() {
		
		String menu = new String("\nHey boss, I heard rumors about Alexa taking over?\n"
				+ "Hope that means a promotion for your best assitant... right?...\n");
		
		return menu;
	}
	
	public static String adminMenu() {
		
		String menu = new String("\n1 : Lookup User\n"
				+ "2 : Lookup Account\n"
				+ "3 : View Account Applications (all pending/closed accounts)\n"
				+ "4 : Deposit\n"
				+ "5 : Withdraw\n"
				+ "6 : Transfer\n"
				+ "7 : Cancel Account\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String initialDepositNotice() {
		
		String menu = new String("\nGreat work so far! To complete your registration you need to deposit an initial amount.\n"
				+ "One of my associates will have to approve your account in order for you to perform transactions.\n\n"
				+ "Please enter your initial deposit: ");
		
		return menu;
	}
	
	public static String registrationCompleteNotice() {
		
		String menu = new String("\nThank you for registering with Revature Financial. Goodbye for now!\n");
		return menu;
	}
	
	public static String successfulRegistration() {
		String menu = new String("\nCongratulations on successfully registering with Revature Financial.\n"
				+ "I'll log you out now but if you'd like to view your account or perform transactions please log in.\n"
				+ "Goodbye!\n");
		return menu;
	}
	
	public static String welcomeOops() {
		
		String menu = "\nYou must be one of those difficult humans. Try again...\n";
		
		return menu;
	}
	
	public static String customerOops() {
		
		String menu = new String("\nI told you, we work in very specific numbers around here. You wanna try again?\n");
		
		return menu;
	}
	
	public static String employeeOops() {
		
		String menu = new String("\nLook, I know I'm clever and all but there's only one of me around here.\n"
				+ "The least you could do is speak my language...\n");
		
		return menu;
	}
	
	public static String adminOops() {
		
		String menu = new String("\nIn order for me to translate that I'm gonna need a raise...\n");
		
		return menu;
	}
	
	
	public static String transOverdraft() {
		
		String menu = "\nCheck your math or watch your spending, you don't have enough funds.\n"
				+ "Programmers words I swear, Janus would never be that rude.\n";
		
		return menu;
	}
	
	
	public static String loginOops() {
		
		String menu = new String("\nI don't have you in our system with those credentials, try again...\n");
		
		return menu;
	}

}
