package com.revature.project0.utilclasses;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.project0.bankinterfaces.InterMenus;
import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.AccountsUsersDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.Status;
import com.revature.project0.models.User;

public class Menus implements InterMenus {
	
	ProjectUtil utility = new ProjectUtil();

	public void customerMenu(User user, AccountDAOImpl accountDAO, UserDAOImpl userDAO, AccountsUsersDAOImpl linkDAO) {
		
		Transactions trans = new Transactions();
		
		try {
			
			int customerInput;
			
			do {
				ArrayList<Account> currentAccounts = accountDAO.getAccountsbyUsername(user.getUsername());
						
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
					
					if (currentAccounts.size() > 1) {
						
						Account fromAccount = utility.chooseAccount(currentAccounts);
						Account toAccount  = utility.chooseAccount(currentAccounts);
						trans.transfer(fromAccount, toAccount);
						accountDAO.updateAccount(toAccount);
						accountDAO.updateAccount(fromAccount);
						
					} else {
						
						System.out.println("\nYou only have one account. Open another account to transfer funds.");
					}
					
					
				} else if (customerInput == 5) {
					
					utility.registerAccount(user, accountDAO, userDAO, linkDAO);
					
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
	public void employeeMenu(User user, ArrayList<Account> accounts, ArrayList<User> users, AccountDAOImpl accountDAO, UserDAOImpl userDAO) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int employeeInput;
			ArrayList <String> usernameList = userDAO.getAllUsernames();
			
			do {
				employeeInput = utility.validEmployeeMenuInput();
				
				if (employeeInput == 1) {
					
					System.out.print("\nEnter the username of the customer your searching for, or enter \"all\" to see all users: ");
					
					String input = sc.next();
					
					if (input.equals("all")) {
						
						for (User u : users) {
							System.out.println("\n" + u);
						}
						
					} else if (usernameList.contains(input)) {
						
						System.out.println(userDAO.getUserByUsername(input));
						
					} else {
						
						System.out.println("\nI can't seem to find that user.");
					}
					
				} else if (employeeInput == 2) {
					
					int input = utility.validAccountViewMenu();
					
					if (input == 1) {
						
						System.out.print("\nEnter the username associated with the account(s): ");
						String username = sc.next();

						ArrayList<Account> selectedAccounts = accountDAO.getAccountsbyUsername(username);
						
						for (Account a : selectedAccounts) {
							System.out.println("\n" + a);
						}
						
					} else if (input == 2) {
						
						System.out.print("\nEnter the account number: ");
						long accountNumber = sc.nextLong();
						
						System.out.println(accountDAO.getAccountByAccountNumber(accountNumber));
						
					} else {
						
						utility.showAccounts(accounts);
					}
					
				} else if (employeeInput == 3) {
					
					ArrayList<Account> accountsToApprove = new ArrayList<Account>();
					
					ArrayList<Account> pendingAccounts = accountDAO.getAccountsByStatus(1);
					
					if (pendingAccounts.size() > 0) {
						
						for (Account a : pendingAccounts) {
							accountsToApprove.add(a);
						}
					}
					
					ArrayList<Account> closedAccounts = accountDAO.getAccountsByStatus(3);
					
					if (closedAccounts.size() > 0) {
						for (Account a : closedAccounts) {
							accountsToApprove.add(a);
						}
					}
					
					if (accountsToApprove.size() == 0) {
						
						System.out.println("\nAll accounts are open.");
						continue;
						
					} else {
						
						utility.showAccounts(accountsToApprove);
						
						System.out.print("\nWould you like to approve these accounts? (y/n): ");
						String input = sc.next();
					
						if (input.equals("y")) {
						
						for (Account a : accountsToApprove) {
							a.setStatus(new Status(2, "open"));
							accountDAO.updateAccount(a);
						}
						
						System.out.println("Complete!");
						
						} else {
						
							System.out.println("Nevermind than...");
						}
					}
					
				} else {
					
					System.out.println(Janus.farewell());
					Thread.sleep(1500);
				}
				
			} while (employeeInput != 0);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void adminMenu(User user, ArrayList<Account> accounts, ArrayList<User> users, AccountDAOImpl accountDAO,
			UserDAOImpl userDAO) {
		
		Transactions trans = new Transactions();
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int adminInput;
			ArrayList <String> usernameList = userDAO.getAllUsernames();
			
			do {
				
				adminInput = utility.validAdminMenuInput();
				
				if (adminInput == 1) {
					
					System.out.print("\nEnter the username of the customer your searching for, or enter \"all\" to see all users: ");
					
					String input = sc.next();
					
					if (input.equals("all")) {
						
						for (User u : users) {
							System.out.println("\n" + u);
						}
						
					} else if (usernameList.contains(input)) {
						
						System.out.println(userDAO.getUserByUsername(input));
						
					} else {
						
						System.out.println("I can't seem to find that user.");
					}
					
				} else if (adminInput == 2) {
					
					int input = utility.validAccountViewMenu();
					
					if (input == 1) {
						
						System.out.print("Enter the username associated with the account(s): ");
						String username = sc.next();

						ArrayList<Account> selectedAccounts = accountDAO.getAccountsbyUsername(username);
						
						for (Account a : selectedAccounts) {
							System.out.println("\n" + a);
						}
						
					} else if (input == 2) {
						
						System.out.print("Enter the account number: ");
						long accountNumber = sc.nextLong();
						
						System.out.println(accountDAO.getAccountByAccountNumber(accountNumber));
						
					} else {
						
						utility.showAccounts(accounts);
					}
					
				} else if (adminInput == 3) {
					
					ArrayList<Account> accountsToApprove = new ArrayList<Account>();
					
					ArrayList<Account> pendingAccounts = accountDAO.getAccountsByStatus(1);
					
					if (pendingAccounts.size() > 0) {
						
						for (Account a : pendingAccounts) {
							accountsToApprove.add(a);
						}
					}
					
					ArrayList<Account> closedAccounts = accountDAO.getAccountsByStatus(3);
					
					if (closedAccounts.size() > 0) {
						
						for (Account a : closedAccounts) {
							accountsToApprove.add(a);
						}
					}
					
					if (accountsToApprove.size() == 0) {
						
						System.out.println("\nAll accounts are open.");
						continue;
						
					} else {
					
						utility.showAccounts(accountsToApprove);
						
						System.out.print("\nWould you like to approve these accounts? (y/n): ");
						
						String input = sc.next();
					
						if (input.equals("y")) {
							
							for (Account a : accountsToApprove) {
								a.setStatus(new Status(2, "open"));
								accountDAO.updateAccount(a);
							}
							
							System.out.println("Complete!");
							
						} else {
							
							System.out.println("Nevermind...");
						}
					}
					
				} else if (adminInput == 4) {
					
					Account depositAccount = utility.chooseAccount(accounts);
					trans.deposit(depositAccount);
					accountDAO.updateAccount(depositAccount);
					
				} else if (adminInput == 5) {
					
					Account withdrawalAccount = utility.chooseAccount(accounts);
					trans.withdraw(withdrawalAccount);
					accountDAO.updateAccount(withdrawalAccount);
					
				} else if (adminInput == 6) {
					
					Account fromAccount = utility.chooseAccount(accounts);
					Account toAccount  = utility.chooseAccount(accounts);
					trans.transfer(fromAccount, toAccount);
					accountDAO.updateAccount(toAccount);
					accountDAO.updateAccount(fromAccount);
					
				} else if (adminInput == 7) {
					
					System.out.println("Choose which account you'd like to close:");
					Account canceledAccount = utility.chooseAccount(accounts);
					canceledAccount.setStatus(new Status(3, "closed"));
					accountDAO.updateAccount(canceledAccount);
					System.out.print("The selected account has been closed.");
				
				} else {
					
					System.out.println(Janus.farewell());
					Thread.sleep(1500);
				}
				
			} while (adminInput != 0);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
}
