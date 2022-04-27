package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.models.Account;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;

public class AccountDAOImpl implements AccountDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override //TESTED
	public int createAccount(Account newAccount) {
		
		int creationId = 0;
		String query = "INSERT INTO accounts (account_num, routing_num, balance, account_type_id, account_status_id) VALUES (?, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			pst.setLong(1, newAccount.getAccountNumber());
			pst.setLong(2, newAccount.getRoutingNumber());
			pst.setDouble(3,  newAccount.getBalance());
			pst.setInt(4, newAccount.getType().getTypeId());
			pst.setInt(5, newAccount.getStatus().getStatusId());
			
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			
			while(rs.next()) {
				
				creationId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return creationId;
	}

	@Override //TESTED
	public Account getAccountById(int accountId) {
		
		Account account = new Account();
		String query = "SELECT accounts.account_id, accounts.account_num, accounts.routing_num, accounts.balance, account_type.account_type_id, account_type.account_type, account_status.account_status_id, account_status.account_status FROM accounts INNER JOIN account_type ON accounts.account_type_id = account_type.account_type_id INNER JOIN account_status ON accounts.account_status_id = account_status.account_status_id WHERE accounts.account_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, accountId);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setAccountNumber(rs.getLong(2));
				account.setRoutingNumber(rs.getLong(3));
				account.setBalance(rs.getDouble(4));
				account.setType(new Type(rs.getInt(5), rs.getString(6)));
				account.setStatus(new Status(rs.getInt(7), rs.getString(8)));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return account;
	}

	@Override //TESTED
	public ArrayList<Account> getAllAccounts() {
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		String query = "SELECT accounts.account_id, accounts.account_num, accounts.routing_num, accounts.balance, account_type.account_type_id, account_type.account_type, account_status.account_status_id, account_status.account_status FROM accounts INNER JOIN account_type ON accounts.account_type_id = account_type.account_type_id INNER JOIN account_status ON accounts.account_status_id = account_status.account_status_id ORDER BY accounts.account_id ASC";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				accountList.add(new Account(
						rs.getInt(1),
						rs.getLong(2),
						rs.getLong(3),
						rs.getDouble(4),
						new Type(rs.getInt(5), rs.getString(6)),
						new Status(rs.getInt(7), rs.getString(8))));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return accountList;
	}

	@Override //TESTED
	public void updateAccount(Account currentAccount) {
		
		String query = "UPDATE accounts SET balance = ?, account_type_id = ?, account_status_id = ? WHERE account_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setDouble(1, currentAccount.getBalance());
			pst.setInt(2, currentAccount.getType().getTypeId());
			pst.setInt(3, currentAccount.getStatus().getStatusId());
			pst.setInt(4, currentAccount.getAccountId());
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override //TESTED
	public void deleteAccountById(int accountId) {
		
		String query = "DELETE FROM accounts WHERE account_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, accountId);
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override //TESTED
	public ArrayList<Account> getAccountsByStatus(int statusId) {
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		String query = "SELECT accounts.account_id, accounts.account_num, accounts.routing_num, accounts.balance, account_type.account_type_id, account_type.account_type, account_status.account_status_id, account_status.account_status FROM accounts INNER JOIN account_type ON accounts.account_type_id = account_type.account_type_id INNER JOIN account_status ON accounts.account_status_id = account_status.account_status_id WHERE accounts.account_status_id = ? ORDER BY accounts.account_id ASC";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, statusId);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				accountList.add(new Account(
						rs.getInt(1),
						rs.getLong(2),
						rs.getLong(3),
						rs.getDouble(4),
						new Type(rs.getInt(5), rs.getString(6)),
						new Status(rs.getInt(7), rs.getString(8))));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return accountList;
	}

	//I don't really know if I need this method or not
	@Override //TESTED
	public ArrayList<Account> getAccountsbyUserId(int userId) {
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		String query = "SELECT accounts.account_id, accounts.account_num, accounts.routing_num, accounts.balance, account_type.account_type_id, account_type.account_type, account_status.account_status_id, account_status.account_status FROM accounts_users INNER JOIN accounts ON accounts_users.account_id = accounts.account_id INNER JOIN account_type ON accounts.account_type_id = account_type.account_type_id INNER JOIN account_status ON accounts.account_status_id = account_status.account_status_id WHERE accounts_users.user_id = ? ORDER BY accounts.account_id ASC";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				accountList.add(new Account(
						rs.getInt(1),
						rs.getLong(2),
						rs.getLong(3),
						rs.getDouble(4),
						new Type(rs.getInt(5), rs.getString(6)),
						new Status(rs.getInt(7), rs.getString(8))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountList;
	}
	
	//TODO add a get account by "joint" type

	
	
}
