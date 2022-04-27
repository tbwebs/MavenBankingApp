package com.revature.project0.daos;

import java.util.ArrayList;

import com.revature.project0.models.AccountsUsers;

public interface AccountsUsersDAO {

	public int createAccountUserLink(AccountsUsers link);
	
	public AccountsUsers getAccountUserLinkById(int accountUserId);
	
	public ArrayList<AccountsUsers> getAccountUserByUserId(int userId);
	
	public void deleteAccountUserById(int linkId);
	
}
