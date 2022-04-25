package com.revature.project0.daos;

import java.util.ArrayList;

import com.revature.project0.models.Account;

public interface AccountDAO {

	public int createAccount(Account newAccount);
	
	public Account getAccountById(int accountId);
	
	public Account getAccountByUser(String username);
	
	public ArrayList<Account> getAllAccounts();

	public void updateAccount(Account currentAccount);
	
	public void deleteAccountById(Account currentAccount);
	
}
