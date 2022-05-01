package com.revature.project0.utilclasses;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.project0.bankinterfaces.InterTransactions;
import com.revature.project0.models.Account;

//think about using setter methods in these methods but I think I'll use another transaction method when building the console flow

public class Transactions implements InterTransactions {
	
	private static final Logger logger = LogManager.getLogger(Transactions.class);

	@Override
	public void deposit(Account account) {
		
		double newBalance = 0;
		
		try {
			
			double accountBalance = account.getBalance();
			
			double amount = this.getAmount();

			newBalance = accountBalance + amount;
			
			account.setBalance(newBalance);
			
			System.out.println("Success!");
			logger.info("Successfully deposited " + amount + " to account " + account.getAccountNumber());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(Account account) {
		
		double accountBalance = account.getBalance();
		double newBalance = 0;
		double amount;
		try {
			
			do {
				
				amount = this.getAmount();
				
				newBalance = accountBalance - amount;
				
				if (newBalance < 0)
					System.out.print(Janus.transOverdraft());
				
			} while (newBalance < 0);
			
			account.setBalance(newBalance);
			
			System.out.println("Success!");
			logger.info("Successfully withdrew " + amount + " from account " + account.getAccountNumber());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void transfer(Account fromAccount, Account toAccount) {
		
		double from = fromAccount.getBalance();
		double reciever = toAccount.getBalance();
		double difference = 0;
		double sum = 0;
		double amount;

		try {
			
			do {
				
				amount = this.getAmount();
				
				difference = from - amount;
				
				
				if (difference < 0)
					System.out.print(Janus.transOverdraft());
				
				sum = reciever + amount;
				
			} while (difference < 0);
			
			fromAccount.setBalance(difference);
			toAccount.setBalance(sum);
			
			System.out.println("Success!");
			logger.info("Successfully transfered " + amount + " to account " + toAccount.getAccountNumber() + " from account " + fromAccount.getAccountNumber());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	//helper method for getting numeric input
	@Override
	public double getAmount() {
	
		Scanner sc = new Scanner(System.in);
		double amount;
		
		do {
			
			System.out.print("Enter an amount (i.e., 10.50): ");
	
			while(!sc.hasNextDouble()) {
		
				String input = sc.next();
				System.out.print("Invalid input, please try again (i.e., 10.50): ");
			}
			
			amount = sc.nextDouble();
			
			if (amount < 0) {
				
				System.out.println("Please enter a positve value greater than zero");
			}
			
		} while (amount < 0);
		
		return amount;
	}
}