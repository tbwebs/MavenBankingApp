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
	public int createAccountsUsersLink(AccountsUsers link) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "INSERT INTO accounts_users(user_id, account_id) VALUES(?, ?)";
		int creationId = 0;
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, link.getUserId());
			pst.setInt(2, link.getAccountId());
			pst.execute();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()) {
				
				creationId = rs.getInt(1);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return creationId;
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
				link.setUserId(rs.getInt(2));
				link.setAccountId(rs.getInt(3));
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
	
	
}
