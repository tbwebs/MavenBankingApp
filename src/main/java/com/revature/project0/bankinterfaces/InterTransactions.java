package com.revature.project0.bankinterfaces;

import com.revature.project0.models.Account;

public interface InterTransactions {
	
	void deposit(Account account);
	
	void withdraw(Account account);
	
	void transfer(Account fromAccount, Account toAccount);
	
	double getAmount();

}
