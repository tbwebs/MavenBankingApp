package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.models.AccountsUsers;

public class AccountsUsersDAOImpl implements AccountsUsersDAO {

	@Override //NEED TO TEST
	public int createAccountUserLink(AccountsUsers link) {
		
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

	@Override //NEED TO TEST
	public AccountsUsers getAccountUserLinkById(int accountUserId) {
		
		Connection conn = ConnectionManager.getConnection();
		String query = "SELECT * FROM accounts_users WHERE accounts_users_id = ?";
		AccountsUsers link = new AccountsUsers();
		
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, accountUserId);
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

	@Override //NEED TO TEST
	public ArrayList<AccountsUsers> getAccountUserByUserId(int userId) {
		
		Connection conn = ConnectionManager.getConnection();
		ArrayList<AccountsUsers> links = new ArrayList<AccountsUsers>();
		String query = "SELECT * FROM accounts_users WHERE accounts_users_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				links.add(new AccountsUsers(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return links;
	}

	@Override //NEED TO TEST
	public void deleteAccountUserById(int linkId) {
		
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
