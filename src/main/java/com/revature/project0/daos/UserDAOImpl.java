package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.models.User;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public int createUser(User newUser) {
		
		String query = "INSERT INTO users(first_name, last_name, username, email, pass_word, user_role_id) VALUES (?, ?, ?, ?, ?, ?)";
		int creationId = 0;
		
		try {
			
			//generating the keys allow's me to create a primary key column for the referenced foreign keys for the user_role table
			//<https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#RETURN_GENERATED_KEYS>
			//also should mention I referenced another revature's student code to figure out how to do this with SQL statements. Thanks Ryan!
			//<https://github.com/RyanEllingson/maven-banking-app/blob/master/src/main/java/dao/BankDAOImpl.java>
			PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, newUser.getFirstName());
			pst.setString(2, newUser.getLastName());
			pst.setString(3, newUser.getUsername());
			pst.setString(4, newUser.getEmail());
			pst.setString(5, newUser.getPassword());
			pst.setInt(6, newUser.getRole().getRoleId());
			
			pst.execute();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			while (rs.next()) {
				creationId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return creationId;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User currentUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(User currentUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> getAllUsernames() {
		// TODO Auto-generated method stub
		return null;
	}

}
