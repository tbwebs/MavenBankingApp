package com.revature.project0.daos;

import java.util.ArrayList;

import com.revature.project0.models.Account;

public interface AccountDAO {

	public int createAccount(Account newAccount);
	
	public Account getAccountById(int accountId);
	
	public ArrayList<Account> getAccountsbyUserId(int userId);
	
	public ArrayList<Account> getAllAccounts();
	
	public ArrayList<Account> getAccountsByStatus(String status);

	public void updateAccount(Account currentAccount);
	
	public void deleteAccountById(int account_id);
	
}
