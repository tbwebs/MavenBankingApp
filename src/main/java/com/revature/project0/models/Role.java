package com.revature.project0.models;

// this class holds data to link role to users database
public class Role {
	
	private int roleId;
	private String role;

	public Role() { super(); }
	
	public Role(int roleId, String role) {
		this.roleId = roleId;
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}