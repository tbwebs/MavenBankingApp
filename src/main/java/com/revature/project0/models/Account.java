package com.revature.project0.models;

import java.util.ArrayList;

//Holds columns for account database. AccountType will be joing or personal, and status will be pending/open/closed
abstract class Account {
	
	private int accountId;
	private long accountNumber;
	private long routingNumber;
	private double balance;
	private AccountType type;
	private AccountStatus status;
	
	
	public Account() { super(); }
	
	//for joint account
	public Account(int accountId, double initialBalance, AccountType type, AccountStatus status) {
		this.accountId = accountId;
		this.accountNumber = generateAccountNumber();
		this.routingNumber = generateRoutingNumber();
		this.balance = initialBalance;
		this.type = type;
		this.status = status;
		
	}
	
	// formula from <https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java>
	// 17 digits
	private long generateAccountNumber() {
		
		int min = 1;
		long max = 10000000000000000L;
		
		long randomNumber = (long) Math.floor(Math.random()*(max-min+1)+min);
		
		return randomNumber;
	}
	
	// formula from <https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java>
	// 9 digits
	private long generateRoutingNumber() {
		
		int min = 1;
		long max = 100000000L;
		
		long randomNumber = (long) Math.floor(Math.random()*(max-min+1)+min);
		
		return randomNumber;
		
	}

	public int getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(int newId) {
		this.accountId = newId;
	}
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(long newNum) {
		this.accountNumber = newNum;
	}
	
	public long getRoutingNumber() {
		return this.routingNumber;
	}
	
	public void setRoutingNumber(long newNum) {
		this.routingNumber = newNum;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalence(double newBalance) {
		this.balance = newBalance;
	}
	
	public AccountStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(AccountStatus newStatus) {
		this.status = newStatus;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public void setType(AccountType newType) {
		this.type = newType;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", routingNumber="
				+ routingNumber + ", balance=" + balance + ", type=" + type + ", status=" + status + "]";
	}
	
}
