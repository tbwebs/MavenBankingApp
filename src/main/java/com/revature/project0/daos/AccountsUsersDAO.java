package com.revature.project0.daos;

import com.revature.project0.models.AccountsUsers;

public interface AccountsUsersDAO {

	public int createAccountUserLink(AccountsUsers link);
	
	public AccountsUsers getAccountUserLinkById(int accountUserId);
	
	public int getAccountUserByBothIds(int accountId, int userId);
	
	public AccountsUsers getAccountUserByUser(int userId);
	
	public AccountsUsers getAccountUserByAccoutNum(int accountId);
	
	public void deleteAccountUserById(int linkId);
	
}
