package com.revature.project0.models;

//Holds columns for account database. AccountType will be joing or personal, and status will be pending/open/closed
public class Account {
	
	private long accountNumber;
	private long routingNumber;
	private double balance;
	private Type type;
	private Status status;
	
	
	public Account() { super(); }
	
	//for joint account
	public Account(long accountNumber, long routingNumber, double initialBalance, Type type, Status status) {
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.balance = initialBalance;
		this.type = type;
		this.status = status;
		
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
	
	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public void setStatus(Status newStatus) {
		this.status = newStatus;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type newType) {
		this.type = newType;
	}

	@Override
	public String toString() {
		return "Account Number : " + accountNumber + "\nRouting Number : " + routingNumber + "\nBalance : $" + balance + "\nType : " + type.getType() + "\nStatus : " + status.getStatus();
	}
	
}
