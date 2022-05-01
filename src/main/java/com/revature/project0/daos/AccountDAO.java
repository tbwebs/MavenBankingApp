package com.revature.project0.daos;

import java.util.ArrayList;

import com.revature.project0.models.Account;

public interface AccountDAO {

	public void createAccount(Account newAccount); // insert a new account into accounts table
	
	public Account getAccountByAccountNumber(long accountNumber);
	
	public ArrayList<Account> getAccountsbyUsername(String username);
	
	public ArrayList<Account> getAllAccounts();
	
	public ArrayList<Account> getAccountsByStatus(int statusId);

	public void updateAccount(Account currentAccount);
	
	public void deleteAccountByAccountNumber(long accountNumber);
	
}
