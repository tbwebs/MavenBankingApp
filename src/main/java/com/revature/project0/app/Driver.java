package com.revature.project0.app;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.RoleDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Role;
import com.revature.project0.models.User;

public class Driver {
		
	public static void main(String[] args) {

		RoleDAOImpl roleDAO = new RoleDAOImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
		
		Role newRole = new Role(1, "customer");
		
		Role vicRole = new Role(2, "customer");

//		roleDAO.createRole(newRole);
//		roleDAO.createRole(vicRole);

		User chloeTest = new User(1, "TEST chloe", "griffith", "cg@gmail.com", "pass", newRole);
		
		User victorTest = new User(2, "TEST vic", "griffin", "vg@gmail.com", "vpass", vicRole);
	
//		userDAO.createUser(victorTest);
//		userDAO.createUser(chloeTest);
		
	
	}
}
