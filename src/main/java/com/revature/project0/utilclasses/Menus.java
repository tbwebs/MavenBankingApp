package com.revature.project0.utilclasses;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.project0.bankinterfaces.InterMenus;
import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.AccountsUsersDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.User;

public class Menus implements InterMenus {
	
	ProjectUtil utility = new ProjectUtil();

	@Override
	public void customerMenu(User user, ArrayList<Account> currentAccounts, AccountDAOImpl accountDAO, UserDAOImpl userDAO, AccountsUsersDAOImpl linkDAO) {
		
		Transactions trans = new Transactions();
		
		try {
			
			int customerInput;
			
			do {
				customerInput = utility.validCustomerMenuInput();
				
				if (customerInput == 1) {
					
					utility.showAccounts(currentAccounts);

				} else if (customerInput == 2) {
					
					Account depositAccount = utility.chooseAccount(currentAccounts);
					trans.deposit(depositAccount);
					accountDAO.updateAccount(depositAccount);
				} else if (customerInput == 3) {
					
					Account withdrawalAccount = utility.chooseAccount(currentAccounts);
					trans.withdraw(withdrawalAccount);
					accountDAO.updateAccount(withdrawalAccount);
				} else if (customerInput == 4) {
					
					Account fromAccount = utility.chooseAccount(currentAccounts);
					Account toAccount  = utility.chooseAccount(currentAccounts);
					trans.transfer(fromAccount, toAccount);
					accountDAO.updateAccount(toAccount);
					accountDAO.updateAccount(fromAccount);
					
				} else if (customerInput == 5) {
					
					utility.registerAccount(userDAO, linkDAO);
					
				} else {
					
					System.out.println(Janus.farewell());
					Thread.sleep(1500);
				}
				
			} while (customerInput != 0);
				
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void employeeMenu(User user, ArrayList<Account> accounts, ArrayList<User> users, AccountDAOImpl accountDAO, UserDAOImpl userDAO,
			AccountsUsersDAOImpl linkDAO) {
		
		
		
	}

	@Override
	public void adminMenu(User user, ArrayList<Account> accounts, ArrayList<User> users, AccountDAOImpl accountDAO,
			UserDAOImpl userDAO, AccountsUsersDAOImpl linkDAO) {
		// TODO Auto-generated method stub
		
	}

}
