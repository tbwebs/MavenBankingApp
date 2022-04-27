package com.revature.project0.app;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.AccountsUsersDAO;
import com.revature.project0.daos.AccountsUsersDAOImpl;
import com.revature.project0.daos.RoleDAOImpl;
import com.revature.project0.daos.StatusDAOImpl;
import com.revature.project0.daos.TypeDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.AccountsUsers;
import com.revature.project0.models.Role;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.models.User;
import com.revature.project0.utilclasses.ProjectUtil;

public class Driver {
		
	public static void main(String[] args) {

		RoleDAOImpl roleDAO = new RoleDAOImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
		TypeDAOImpl typeDAO = new TypeDAOImpl();
		StatusDAOImpl statusDAO = new StatusDAOImpl();
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		AccountsUsersDAOImpl linkDAO = new AccountsUsersDAOImpl();
		
		Role customer = new Role(1, "customer");
		Role employee = new Role(2, "employee");
		Role admin = new Role(3, "admin");
		
		Type personal = new Type(1, "personal");
		Type joint = new Type(2, "joint");
		
		Status pending = new Status(1, "pending");
		Status open = new Status(2, "open");
		Status closed = new Status(3, "closed");
		
		User chloeTest = new User(1, "TEST chloe", "griffith", "cg@gmail.com", "pass", customer);
		User victorTest = new User(2, "TEST vic", "griffin", "vg@gmail.com", "vpass", customer);
		User treyTest = new User(3, "TEST trey", "web", "tb@gmail.com", "tpass", customer);
	
		long acctNum = ProjectUtil.generateAccountNumber();
		long routNum = ProjectUtil.generateRoutingNumber();
		
		long acctNum1 = ProjectUtil.generateAccountNumber();
		long routNum1 = ProjectUtil.generateRoutingNumber();
		
		Account account1 = new Account(1, acctNum, routNum, 100.00, personal, pending);
		Account account2 = new Account(2, acctNum1, routNum1, 22, joint , open);
		
		AccountsUsers account1link = new AccountsUsers(1, chloeTest.getUserId(), account1.getAccountId());
		AccountsUsers account2jointlink = new AccountsUsers(2, victorTest.getUserId(), account2.getAccountId());
		AccountsUsers account2jointlink1 = new AccountsUsers(3, treyTest.getUserId(), account2.getAccountId());
		
		ArrayList<User> userList = userDAO.getUsersByAccountId(2);
		
		for (User i : userList) {
			System.out.println(i);
		}

	

		
		
	}
}
