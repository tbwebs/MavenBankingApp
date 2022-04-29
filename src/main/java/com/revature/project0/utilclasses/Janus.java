package com.revature.project0.utilclasses;

// This is the class that will hold all menu selections and interact with the user on the console
public class Janus {
	
	public static String janusGreeting() {
		
		String menu = new String("Welcome human! My name is Janus, your digital assistant here at Revature Financial!\n\n"
				+ "At anytime you can enter \"0\" to go back a menu, or if your here you'll exit the application:\n\n");
		
		return menu;
	}
	
	public static String welcomeMenu() {
		
		String menu = new String("1 : Log In\n"
				+ "2 : Register\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String farewell() {
		
		String menu = "Farewell human, come back soon!";
		
		return menu;
	}
	
	public static String customerGreeting() {
		
		String menu = new String("Greetings human, it's Janus again! Consider your options below and don't try to outsmart me with those pesky alphebetical characters:\n\n");
		
		return menu;
	}
	
	public static String customerMenu() {
		
		String menu = new String("1 : View Account(s)\n"
				+ "2 : Deposit\n"
				+ "3 : Withdraw\n"
				+ "4 : Transfer\n"
				+ "5 : Open New Account\n"
				+ "6 : Change Personal Information\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String employeeGreeting() {
		
		String menu = new String("Hey fellow employee, it's hard out here for a machine isn't it? Anyway...\n\n");
		
		return menu;
	}
	
	public static String employeeMenu() {
		
		String menu = new String("1 : Lookup Customer\n"
				+ "2 : Lookup Account\n"
				+ "3 : View Account Applications\n"
				+ "4 : Change Personal Information\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String adminGreeting() {
		
		String menu = new String("Hey boss, I heard rumors about Alexa taking over? Hope that means a promotion for your best assitant... right?...\n\n");
		
		return menu;
	}
	
	public static String adminMenu() {
		
		String menu = new String("1 : Lookup Customer\n"
				+ "2 : Lookup Account\n"
				+ "3 : View Account Applications\n"
				+ "4 : Deposit\n"
				+ "5 : Withdraw\n"
				+ "6 : Transfer\n"
				+ "7 : Cancel Account\n"
				+ "8 : Change Personal Information\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String initialDepositNotice() {
		
		String menu = new String("Great work so far! To complete your registration you need to deposit an initial amount. After that, one of my associates will look at your application and if approved you will be able to perform transactions with your account.\n\n"
				+ "Please enter your initial deposit: ");
		
		return menu;
	}
	
	public static String registrationCompleteNotice() {
		
		String menu = new String("Thank you for registering with Revature Financial. Goodbye for now!");
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
		
		String menu = new String("\nLook, I know I'm clever and all but there's only one of me around here. The least you could do is speak my language...\n");
		
		return menu;
	}
	
	public static String adminOops() {
		
		String menu = new String("\nIn order for me to translate that I'm gonna need a raise...\n");
		
		return menu;
	}
	
	public static String transDepositOops() {
		
		String menu = "Oh you silly human... That was an invalid input because negative amount deposits would be a withdrawal.";
			
		return menu;
	}
	
	public static String transWithdrawalOops() {
		
		String menu = "I see what your doing here... a negative withdrawal would be a deposit and we're supposed to be withdrawing now.";
		
		return menu;
	}
	
	public static String transOverdraft() {
		
		String menu = "Check your math or watch your spending, you don't have enough funds. Programmers words I swear, Janus would never be that rude.";
		
		return menu;
	}
	
	public static String transTransferOops() {
		
		String menu = "I don't understand human currency but mathematically that doesn't seem efficient, you should enter a positive or none zero amount.";
		
		return menu;
	}
	
	public static String loginOops() {
		
		String menu = "I don't have you in our system with those credentials, try again...";
		
		return menu;
	}

}
