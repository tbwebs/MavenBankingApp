package com.revature.project0.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.Role;

public interface RoleDAO {

	public ArrayList<Role> getAllRoles();
	
	public void createRole(Role role);
	
}
