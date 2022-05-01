package com.revature.project0.models;

// this class links the user and accounts
public class AccountsUsers {

	private int id;
	private String username;
	private long accountNumber;
	
	public AccountsUsers(){ super(); }
	
	public AccountsUsers(int id, String username, long accountNumber) {
		this.id = id;
		this.username = username;
		this.accountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

}
