package com.revature.project0.utilclasses;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.project0.bankinterfaces.InterUtil;
import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.daos.AccountsUsersDAOImpl;
import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.AccountsUsers;
import com.revature.project0.models.Role;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.models.User;

//Where all my helper methods are
public class ProjectUtil implements InterUtil {
	
	@Override
	public String cleanName(String name) {
		String cleanedName = name.substring(0, 1).toUpperCase() + name.substring(1);
		return cleanedName;
	}
	
	@Override
	public ArrayList<String> login(UserDAOImpl userDAO) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> credentials = new ArrayList<String>();
		String username;
		String password;
		
		try {
			
			do {
				
				System.out.print("\nEnter your username: ");
				username = sc.next();
				System.out.print("Enter your password: ");
				password = sc.next();
				
				if (username.equals("0") || password.equals("0")) {
					credentials.add("0");
					break;
				
				} else if (userDAO.doesUserExist(username, password)) {
					
					credentials.add(username);
					credentials.add(password);
					
				} else if (!userDAO.doesUserExist(username, password)) {
					
					System.out.print(Janus.loginOops());
					
				} else {
					
					continue;
				}
					
			} while(!userDAO.doesUserExist(username, password));
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return credentials;
	}
	
	public boolean checkUsername(ArrayList<String> usernameList, String username) {
		
		return usernameList.contains(username);
	}
	
	@Override
	public User registerUser(UserDAOImpl userDAO) {
		
		User currentUser = new User();
		Role currentRole = new Role();
		String firstName;
		String lastName;
		String username;
		String email;
		String password;
		int roleSelection;
		ArrayList<String> usernameList = userDAO.getAllUsernames();
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("Enter your first name: ");
			String rawfirstName = sc.next();
			firstName = this.cleanName(rawfirstName);
			
			System.out.print("Enter your last name: ");
			String rawlastName = sc.next();
			lastName = this.cleanName(rawlastName);
			
			do {
				System.out.print("Enter a username (prompt will repeat if username already exists): ");
				username = sc.next();
			
			} while (this.checkUsername(usernameList, username));
			
			System.out.print("Enter your email: ");
			email = sc.next();
			
			System.out.print("Enter your password: ");
			password = sc.next();
			
			roleSelection = this.selectRegistrationRole();
			
			if (roleSelection == 1) {
				
				currentRole.setRoleId(1);
				currentRole.setRole("customer");
				
			} else if (roleSelection == 2) {
				
				currentRole.setRoleId(2);
				currentRole.setRole("employee");
				
			} else {
				
				currentRole.setRoleId(3);
				currentRole.setRole("admin");
			}
			
			currentUser.setUsername(username);
			currentUser.setPassword(password);
			currentUser.setFirstName(firstName);
			currentUser.setLastName(lastName);
			currentUser.setEmail(email);
			currentUser.setRole(currentRole);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return currentUser;
	}

	@Override
	public Account registerAccount(User currentUser, AccountDAOImpl accountDAO, UserDAOImpl userDAO, AccountsUsersDAOImpl linkDAO) {
		
		Account newAccount = new Account();
		Type newType = new Type();
		Status pendingStatus = new Status(1, "pending");
		AccountsUsers link = new AccountsUsers();
		long newAccountNum = this.generateAccountNumber();
		long newRoutingNum = this.generateRoutingNumber();
		double initialDeposit;
		int typeSelection;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			typeSelection = this.selectRegisterAccountType();
			
			if (typeSelection == 1) {
				
				newType.setTypeId(1);
				newType.setType("personal");
				
				initialDeposit = this.getInitialDeposit();
				newAccount.setBalance(initialDeposit);
				newAccount.setAccountNumber(newAccountNum);
				newAccount.setRoutingNumber(newRoutingNum);
				newAccount.setType(newType);
				newAccount.setStatus(pendingStatus);
				
				accountDAO.createAccount(newAccount);
				
				int count = linkDAO.getLinkCount();
				link = new AccountsUsers(count + 1, currentUser.getUsername(), newAccount.getAccountNumber());
				linkDAO.createAccountsUsersLink(link);
				
			} else {
				
				AccountsUsers jointLink = new AccountsUsers();
				
				System.out.println("\nPlease register the second account holder.");
				User secondUser = this.registerUser(userDAO);
				userDAO.createUser(secondUser);
				
				newType.setTypeId(2);
				newType.setType("joint");
				
				initialDeposit = this.getInitialDeposit();
				newAccount.setBalance(initialDeposit);
				newAccount.setAccountNumber(newAccountNum);
				newAccount.setRoutingNumber(newRoutingNum);
				newAccount.setType(newType);
				newAccount.setStatus(pendingStatus);
				
				accountDAO.createAccount(newAccount);
				
				int count = linkDAO.getLinkCount();
				link = new AccountsUsers(count + 1, currentUser.getUsername(), newAccount.getAccountNumber());
				
				int jointCount = linkDAO.getLinkCount();
				jointLink = new AccountsUsers(jointCount + 1, secondUser.getUsername(), newAccount.getAccountNumber());
				
				linkDAO.createAccountsUsersLink(link);
				linkDAO.createAccountsUsersLink(jointLink);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return newAccount;
	}
	
	// formula from <https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java>
	// Max of 17 digits
	public long generateAccountNumber() {
		
		int min = 1;
		long max = 10000000000000000L;
		
		long randomNumber = (long) Math.floor(Math.random()*(max-min+1)+min);
		
		return randomNumber;
	}
	
	// formula from <https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java>
	// 9 digits
	public long generateRoutingNumber() {
		
		int min = 1;
		long max = 100000000L;
		
		long randomNumber = (long) Math.floor(Math.random()*(max-min+1)+min);
		
		return randomNumber;
		
	}
	
	public int validAccountViewMenu() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			System.out.print(Janus.accountLookupMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println("\nInvalid input, try again.");
				System.out.print(Janus.accountLookupMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 3 || numInput < 0)
				System.out.print("Invalid Input, try Again");
			
		} while (numInput < 0|| numInput > 3);
		
		return numInput;
	}

	/*
	 * The following 4 methods will be menu loops to validate input from human
	 * Return 0 for "exit" keyword, otherwise need to return appropriate menu number.
	 * Loops if there isn't a valid input (alpha characters, negative numbers, etc.
	 * https://kodejava.org/how-do-i-validate-input-when-using-scanner/#:~:text=To%20validate%20input%20the%20Scanner,provide%20a%20positive%20integer%20number.
	 * */
	@Override
	public int validWelcomeMenuInput() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			
			System.out.print(Janus.welcomeMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println(Janus.welcomeOops());
				System.out.print(Janus.welcomeMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 2) {
				
				System.out.println(Janus.welcomeOops());
				
			} else if (numInput < 0) {
				
				System.out.println(Janus.welcomeOops());
				
			} else {
				
				continue;
			}
			
		} while (numInput < 0|| numInput > 2);
		
		return numInput;
		
	}

	@Override
	public int validCustomerMenuInput() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			
			System.out.print(Janus.customerMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println(Janus.customerOops());
				System.out.print(Janus.customerMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 5) {
				
				System.out.println(Janus.customerOops());
				
			} else if (numInput < 0) {
				
				System.out.println(Janus.customerOops());
				
			} else {
				
				continue;
			}
			
		} while (numInput < 0|| numInput > 5);
		
		return numInput;
	}

	@Override
	public int validEmployeeMenuInput() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			
			System.out.print(Janus.employeeMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println(Janus.employeeOops());
				System.out.print(Janus.employeeMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 3) {
				
				System.out.println(Janus.employeeOops());
				
			} else if (numInput < 0) {
				
				System.out.println(Janus.employeeOops());
				
			} else {
				
				continue;
			}
			
		} while (numInput < 0|| numInput > 3);
		
		return numInput;

	}

	@Override
	public int validAdminMenuInput() {
		
		Scanner sc = new Scanner(System.in);
		int numInput;
		
		do {
			
			System.out.print(Janus.adminMenu());
			
			while (!sc.hasNextInt()) {
				
				String input = sc.next();
				System.out.println(Janus.adminOops());
				System.out.print(Janus.adminMenu());
			}
			
			numInput = sc.nextInt();
			
			if (numInput > 7) {
				
				System.out.println(Janus.adminOops());
				
			} else if (numInput < 0) {
				
				System.out.println(Janus.adminOops());
				
			} else {
				
				continue;
			}
			
		} while (numInput < 0 || numInput > 7);
		
		return numInput;
	}
	
	public boolean checkAccountStatus(Account account) {
		
		String status = account.getStatus().getStatus();
		
		if (status.equals("open"))
			return true;
		
		return false;
	}

	public void showAccounts(ArrayList<Account> accounts) {
		
		int count = 0;
		
		for (int i = 0; i < accounts.size(); i++) {
			count++;
			System.out.println("\nAccount " + count + "\n" + accounts.get(i));
		}
		
	}
	
	//TODO implement check for count being too big or small.
	public Account chooseAccount(ArrayList<Account> accounts) {
		
		Scanner sc = new Scanner(System.in);
		Account chosenAccount = new Account();
		
		try {
			do {
				int count = 0;
				
				for (Account a : accounts) {
					count++;
					System.out.println("\nAccount " + count + "\n" + a);
				}
				
				System.out.print("\nEnter the number of the account you would like to choose (i.e. \"1\"): ");
				
				while (!sc.hasNextInt()) {
					String input = sc.next();
					System.out.print("Invalid input. Enter the number corresponding to your account (i.e. \"1\"): ");
				}
				
				count = sc.nextInt();
				
				if (count == 0) {
					System.out.print("Nevermind...");
					return null;
				}
				
				chosenAccount = accounts.get(count-1);
			
				
				
				if (!checkAccountStatus(chosenAccount)) {
					System.out.println("That account is either closed or pending.\n"
							+ "You can only perform transactions with open accounts...");
					
					Thread.sleep(2000);
				}
				
			} while (!checkAccountStatus(chosenAccount));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chosenAccount;
	}

	@Override
	public int selectRegistrationRole() {
		int numInput;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("What is your role with Revature Financial?\n"
					+ "1 : New customer\n"
					+ "2 : New employee\n"
					+ "3 : New admin\n"
					+ "Input: ");
			
			while (!sc.hasNextInt()) {
				String input = sc.next();
				System.out.println("Select a number, 1 through 3, to choose your role with us.");
				System.out.print("What is your role with Revature Financial?\n"
						+ "1 : New customer\n"
						+ "2 : New employee\n"
						+ "3 : New admin\n"
						+ "Input: ");
			}
			
			numInput = sc.nextInt();
			
		} while (numInput < 0 || numInput > 3);
		
		return numInput;
	}
	
	@Override
	public int selectRegisterAccountType() {
		int numInput;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("\nWhat kind of account do you want to open?\n"
					+ "1 : personal\n"
					+ "2 : joint\n"
					+ "Input: ");
			
			while (!sc.hasNextInt()) {
				String input = sc.next();
				System.out.println("Select a number, 1 through 2, to choose your account type.");
				System.out.print("What kind of account do you want to open?\n"
						+ "1 : personal\n"
						+ "2 : joint\n"
						+ "Input: ");
			}
			
			numInput = sc.nextInt();
			
		} while (numInput < 0 || numInput > 2);
		
		return numInput;
	}
	
	public double getInitialDeposit() {
	
		Scanner sc = new Scanner(System.in);
		double deposit;
		
		do {
			
			System.out.print(Janus.initialDepositNotice());
		
			while(!sc.hasNextDouble()) {
				
				String input = sc.next();
				System.out.print("Please enter a positive numeric amount more than zero: ");
		
			}
			deposit = sc.nextDouble();
		
		} while (deposit < 0);
		
	return deposit;
	}

}
