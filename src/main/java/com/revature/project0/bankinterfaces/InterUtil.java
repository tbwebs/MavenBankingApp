package com.revature.project0.bankinterfaces;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.AccountsUsersDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.Role;
import com.revature.project0.models.User;

/*
 * I still need a loop method. Needs to check input with scanner class somehow
 * */

public interface InterUtil {
	
	public String cleanName(String name);
	
	ArrayList<String> login(UserDAOImpl userDAO);
	
	//validates menu input
	int validWelcomeMenuInput();
	
	//validates menu input
	int validCustomerMenuInput();
	
	//validates menu input
	int validEmployeeMenuInput();
	
	//validates menu input
	int validAdminMenuInput();
	
	boolean checkAccountStatus(Account account);
	
	void showAccounts(ArrayList<Account> accounts);
	
	Account chooseAccount(ArrayList<Account> accounts);
	
	//for account model 
	long generateAccountNumber();
	
	//for account model
	long generateRoutingNumber();
	
	int selectRegistrationRole();

	boolean checkUsername(ArrayList<String> usernameList, String username);
	
	// creates new 
	User registerUser(UserDAOImpl userDAO);
	
	Account registerAccount(User currentUser,AccountDAOImpl accountDAO, UserDAOImpl userDAO, AccountsUsersDAOImpl linkDAO);
	
	int selectRegisterAccountType();
	
	double getInitialDeposit();

}