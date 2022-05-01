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

	@Override //TESTED
	public void createAccount(Account newAccount) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "INSERT INTO accounts (account_num, routing_num, balance, account_type_id, account_status_id) VALUES (?, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			
			pst.setLong(1, newAccount.getAccountNumber());
			pst.setLong(2, newAccount.getRoutingNumber());
			pst.setDouble(3,  newAccount.getBalance());
			pst.setInt(4, newAccount.getType().getTypeId());
			pst.setInt(5, newAccount.getStatus().getStatusId());
			
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override //TESTED
	public Account getAccountByAccountNumber(long accountNumber) {
		
		Connection conn = ConnectionManager.getConnection();
		
		Account account = new Account();
		String query = "SELECT accounts.account_num, accounts.routing_num, accounts.balance, account_type.account_type_id, account_type.account_type, account_status.account_status_id, account_status.account_status FROM accounts INNER JOIN account_type ON accounts.account_type_id = account_type.account_type_id INNER JOIN account_status ON accounts.account_status_id = account_status.account_status_id WHERE accounts.account_num = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setLong(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				account.setAccountNumber(rs.getLong(1));
				account.setRoutingNumber(rs.getLong(2));
				account.setBalance(rs.getDouble(3));
				account.setType(new Type(rs.getInt(4), rs.getString(5)));
				account.setStatus(new Status(rs.getInt(6), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return account;
	}

	@Override //TESTED
	public ArrayList<Account> getAllAccounts() {
		
		Connection conn = ConnectionManager.getConnection();
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		String query = "SELECT accounts.account_num, accounts.routing_num, accounts.balance, account_type.account_type_id, account_type.account_type, account_status.account_status_id, account_status.account_status FROM accounts INNER JOIN account_type ON accounts.account_type_id = account_type.account_type_id INNER JOIN account_status ON accounts.account_status_id = account_status.account_status_id";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				accountList.add(new Account(

						rs.getLong(1),
						rs.getLong(2),
						rs.getDouble(3),
						new Type(rs.getInt(4), rs.getString(5)),
						new Status(rs.getInt(6), rs.getString(7))));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return accountList;
	}

	@Override //TESTED
	public void updateAccount(Account currentAccount) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "UPDATE accounts SET balance = ?, account_type_id = ?, account_status_id = ? WHERE account_num = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setDouble(1, currentAccount.getBalance());
			pst.setInt(2, currentAccount.getType().getTypeId());
			pst.setInt(3, currentAccount.getStatus().getStatusId());
			pst.setLong(4, currentAccount.getAccountNumber());
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override //TESTED
	public void deleteAccountByAccountNumber(long accountNumber) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "DELETE FROM accounts WHERE account_num = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setLong(1, accountNumber);
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override //TESTED
	public ArrayList<Account> getAccountsByStatus(int statusId) {
		
		Connection conn = ConnectionManager.getConnection();
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		String query = "SELECT accounts.account_num, accounts.routing_num, accounts.balance, account_type.account_type_id, account_type.account_type, account_status.account_status_id, account_status.account_status FROM accounts INNER JOIN account_type ON accounts.account_type_id = account_type.account_type_id INNER JOIN account_status ON accounts.account_status_id = account_status.account_status_id WHERE accounts.account_status_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, statusId);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				accountList.add(new Account(
						rs.getLong(1),
						rs.getLong(2),
						rs.getDouble(3),
						new Type(rs.getInt(4), rs.getString(6)),
						new Status(rs.getInt(6), rs.getString(7))));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return accountList;
	}

	//I don't really know if I need this method or not
	@Override //TESTED
	public ArrayList<Account> getAccountsbyUsername(String username) {
		
		Connection conn = ConnectionManager.getConnection();
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		String query = "SELECT accounts.account_num, accounts.routing_num, accounts.balance, account_type.account_type_id, account_type.account_type, account_status.account_status_id, account_status.account_status FROM accounts_users INNER JOIN accounts ON accounts_users.account_num = accounts.account_num INNER JOIN account_type ON accounts.account_type_id = account_type.account_type_id INNER JOIN account_status ON accounts.account_status_id = account_status.account_status_id WHERE accounts_users.username = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				accountList.add(new Account(
						rs.getLong(1),
						rs.getLong(2),
						rs.getDouble(3),
						new Type(rs.getInt(4), rs.getString(5)),
						new Status(rs.getInt(6), rs.getString(7))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountList;
	}
	
	//TODO add a get account by "joint" type

	
	
}
