package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.models.AccountsUsers;

public class AccountsUsersDAOImpl implements AccountsUsersDAO {

	@Override //TESTED
	public void createAccountsUsersLink(AccountsUsers link) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "INSERT INTO accounts_users(username, account_num) VALUES(?, ?)";
		int creationId = 0;
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, link.getUsername());
			pst.setLong(2, link.getAccountNumber());
			pst.execute();
		
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override //TESTED
	public AccountsUsers getAccountsUsersLinkById(int accountsUsersId) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "SELECT * FROM accounts_users WHERE accounts_users_id = ?";
		AccountsUsers link = new AccountsUsers();
		
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, accountsUsersId);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				link.setId(rs.getInt(1));
				link.setUsername(rs.getString(2));
				link.setAccountNumber(rs.getLong(3));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return link;
	}


	@Override //TESTED
	public void deleteAccountsUsersById(int linkId) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "DELETE FROM accounts_users WHERE accounts_users_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, linkId);
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public int getLinkCount() {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "SELECT COUNT(*) FROM accounts_users";
		int count = 0;
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return count;
	}
	
	
}
