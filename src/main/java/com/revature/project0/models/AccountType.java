package com.revature.project0.models;

//This class holds account type data to link with account database, either joint or personal.
public class AccountType {

	private int typeId;
	private String type;
	
	public AccountType() { super(); }
	
	public AccountType(int typeId, String type) {
		this.typeId = typeId;
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AccountType [typeId=" + typeId + ", type=" + type + "]";
	}
	
	
}
