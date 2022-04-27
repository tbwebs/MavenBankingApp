package com.revature.project0.app;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.RoleDAOImpl;
import com.revature.project0.daos.StatusDAOImpl;
import com.revature.project0.daos.TypeDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Role;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.models.User;

public class Driver {
		
	public static void main(String[] args) {

		RoleDAOImpl roleDAO = new RoleDAOImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
		TypeDAOImpl typeDAO = new TypeDAOImpl();
		StatusDAOImpl statusDAO = new StatusDAOImpl();
		
//		Role newRole = new Role(1, "customer");
//		
//		Role vicRole = new Role(2, "customer");

//		roleDAO.createRole(newRole);
//		roleDAO.createRole(vicRole);

//		User chloeTest = new User(1, "TEST chloe", "griffith", "cg@gmail.com", "pass", newRole);
//		
//		User victorTest = new User(2, "TEST vic", "griffin", "vg@gmail.com", "vpass", vicRole);
		
		Type firstType = new Type(1, "personal");
		Type secondType = new Type(2, "joint");
		
		Status firstStatus = new Status(1, "pending");
		Status secondStatus = new Status(2, "open");
		
		
		ArrayList<Status> list = statusDAO.getAllStatuses();
		
		for (Status i : list) {
			System.out.println(i);
		}
		
	}
}
