package com.revature.project0.daos;

import java.util.ArrayList;

import com.revature.project0.models.Account;

public interface AccountDAO {

	public int createAccount(Account newAccount); // insert a new account into accounts table
	
	public Account getAccountById(int accountId);
	
	public ArrayList<Account> getAccountsbyUserId(int userId);
	
	public ArrayList<Account> getAllAccounts();
	
	public ArrayList<Account> getAccountsByStatus(int statusId);

	public void updateAccount(Account currentAccount);
	
	public void deleteAccountById(int account_id);
	
}
