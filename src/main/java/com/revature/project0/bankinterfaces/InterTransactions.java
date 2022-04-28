package com.revature.project0.bankinterfaces;

import com.revature.project0.models.Account;

public interface InterTransactions {
	
	double deposit(double amount, Account account);
	
	double withdraw(double amount, Account account);
	
	double transfer(double amount, Account fromAccount, Account toAccount);

}
