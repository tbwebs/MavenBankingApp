package com.revature.project0.daos;

import java.util.ArrayList;

import com.revature.project0.models.AccountsUsers;

public interface AccountsUsersDAO {

	public int createAccountsUsersLink(AccountsUsers link);
	
	public AccountsUsers getAccountsUsersLinkById(int accountsUsersId);
	
	public void deleteAccountsUsersById(int linkId);
	
}
