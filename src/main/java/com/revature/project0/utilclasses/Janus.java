package com.revature.project0.utilclasses;

// This is the class that will hold all menu selections and interact with the user on the console
public class Janus {
	
	public static String welcomeMenu() {
		
		String menu = new String("Welcome human! My name is Janus, your digital assistant here at Revature Financial!\n\n"
				+ "If you're here by mistake enter \"exit\", but I'd prefer you enter a number to get started:\n\n"
				+ "1 : Log In\n"
				+ "2 : Register\n"
				+ "Input: ");
		
		return menu;
	}
	
	public static String customerGreeting(String customerName) {
		
		String menu = new String("Greetings " + customerName + ", Janus here! Consider your options below and don't try to outsmart me with those pesky alphebetical characters:\n\n");
		
		return menu;
	}
	
	public static String customerMenu(String customerName) {
		
		String menu = new String("1 : View Account(s)\n"
				+ "1 : Deposit\n"
				+ "2 : Withdraw\n"
				+ "3 : Transfer\n"
				+ "4 : Open New Account"
				+ "5 : Change Personal Information"
				+ "6 : Log Out\n");
		
		return menu;
	}
	
	public static String employeeGreeting(String employeeName) {
		
		String menu = new String("Hey " + employeeName + ", it's hard out here for a machine isn't it? Anyway...\n\n");
		
		return menu;
	}
	
	public static String employeeMenu(String employeeName) {
		
		String menu = new String("1 : Lookup Customer\n"
				+ "1 : Lookup Account\n"
				+ "2 : View Account Applications"
				+ "3 : Change Personal Information"
				+ "4 : Log Out\n");
		
		return menu;
	}
	
	public static String adminGreeting() {
		
		String menu = new String("Hey boss, I heard rumors about Alexa taking over? Hope that means a promotion for your best assitant... right?...\n\n");
		
		return menu;
	}
	
	public static String adminMenu() {
		
		String menu = new String("1 : Lookup Customer\n"
				+ "1 : Lookup Account\n"
				+ "2 : View Account Applications"
				+ "3 : Deposit"
				+ "4 : Withdraw"
				+ "5 : Transfer"
				+ "6 : Cancel Account"
				+ "7 : Change Personal Info"
				+ "8 : Log Out");
		
		return menu;
	}
	
	public static String usernameNotice() {
		
		String menu = new String("Got an original silly username? That's too bad because I really like making them for our customers. Consider it a courtesy.");
		
		return menu;
	}
	
	public static String welcomeOops() {
		
		String menu = "You must be one of those difficult humans...";
		
		return menu;
	}
	
	public static String customerOops() {
		
		String menu = new String("I told you, we work in numbers around here. You wanna try again?");
		
		return menu;
	}
	
	public static String employeeOops() {
		
		String menu = new String("Look I know I'm clever and all but there's only one of me around here. The least you could do is speak my language...");
		
		return menu;
	}
	
	public static String adminOops() {
		
		String menu = new String("In order for me to translate that I'm gonna need a raise...");
		
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
		
		String menu = "So I'm not going to transfer no money between accounts... I don't understand human currency but mathematically that doesn't seem efficient.";
		
		return menu;
	}
	
	

}
