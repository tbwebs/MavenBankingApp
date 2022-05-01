package com.revature.project0.bankinterfaces;

import java.util.ArrayList;

import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.AccountsUsersDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.User;

public interface InterMenus {

	void customerMenu(User user, ArrayList<Account> currentAccoutns, AccountDAOImpl accountDAO, UserDAOImpl userDAO, AccountsUsersDAOImpl linkDAO);
	
	void employeeMenu(User user, ArrayList<Account> accounts, ArrayList<User> users, AccountDAOImpl accountDAO, UserDAOImpl userDAO, AccountsUsersDAOImpl linkDAO);
	
	void adminMenu(User user, ArrayList<Account> accounts, ArrayList<User> users, AccountDAOImpl accountDAO, UserDAOImpl userDAO, AccountsUsersDAOImpl linkDAO);
	
}
