package com.revature.project0.utilclasses;

import com.revature.project0.bankinterfaces.InterTransactions;
import com.revature.project0.models.Account;

//think about using setter methods in these methods but I think I'll use another transaction method when building the console flow

public class Transactions implements InterTransactions {

	@Override
	public double deposit(double amount, Account account) {
		
		double accountBalance = account.getBalance();
		double newBalance = 0;
		
		try {
			if (amount < 0 || amount == 0) {
				Janus.transDepositOops();
				
			} else {
				
				newBalance = accountBalance + amount;
			}
				
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return newBalance;
	}

	@Override
	public double withdraw(double amount, Account account) {
		
		double accountBalance = account.getBalance();
		double newBalance = 0;
		
		try {
			if (amount < 0 || amount == 0) {
				
				Janus.transWithdrawalOops();
				
			} else {
				
				newBalance = accountBalance - amount;
				
				if (newBalance < 0) {
					
					Janus.transOverdraft();
					
				} else {
					
					return newBalance;
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return newBalance;
	}

	@Override
	public double transfer(double amount, Account fromAccount, Account toAccount) {
		
		double from = fromAccount.getBalance();
		double reciever = toAccount.getBalance();
		double difference = 0;
		double sum = 0;
		
		try {
			if (amount < 0 || amount == 0) {
				
				Janus.transTransferOops();
				
			} else {
				
				difference = from - amount;
				
				if (difference < 0) {
					
					Janus.transOverdraft();
					
				} else {
					
					sum = reciever + amount;
					
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return sum;
	}

}
