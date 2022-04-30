package com.revature.project0.bankinterfaces;

import com.revature.project0.models.Account;

public interface InterTransactions {
	
	double deposit(Account account);
	
	double withdraw(Account account);
	
	double transfer(Account fromAccount, Account toAccount);
	
	double getAmount();

}
