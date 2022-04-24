package com.revature.project0.models;

// this class links the user and accounts
public class AccountsUsers {

	private int id;
	private int userId;
	private int accountId;
	
	public AccountsUsers(){ super(); }
	
	public AccountsUsers(int id, int userId, int accountId) {
		this.id = id;
		this.userId = userId;
		this.accountId = accountId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "AccountUsers [id=" + id + ", userId=" + userId + ", accountId=" + accountId + "]";
	}

	
}
