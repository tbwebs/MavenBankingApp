package com.revature.project0.models;

//This class holds account type data to link with account database, either joint or personal.
public class Type {

	private int typeId;
	private String type;
	
	public Type() { super(); }
	
	public Type(int typeId, String type) {
		this.typeId = typeId;
		this.type = type;
	}

	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AccountType [typeId=" + typeId + ", type=" + type + "]";
	}
	
	
}
