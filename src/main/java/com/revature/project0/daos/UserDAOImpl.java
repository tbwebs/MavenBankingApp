package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.models.Role;
import com.revature.project0.models.User;

public class UserDAOImpl implements UserDAO {

	@Override //TESTED
	public int createUser(User newUser) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "INSERT INTO users(first_name, last_name, username, email, pass_word, user_role_id) VALUES (?, ?, ?, ?, ?, ?)";
		int creationId = 0;
		
		try {
			
			//generating the keys allow's me to create a primary key column for the referenced foreign keys for the user_role table
			//<https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#RETURN_GENERATED_KEYS>
			//also I should mention I referenced another revature student's code to figure out how to do this with SQL statements. Thanks Ryan!
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
		//still need to think about how I can use this
		return creationId;
	}

	@Override //TESTED
	public User getUserById(int userId) {
		
		Connection conn = ConnectionManager.getConnection();
		
		User user = new User();
		String query = "SELECT users.user_id, users.first_name, users.last_name, users.username, users.email, users.pass_word, user_role.user_role_id, user_role.user_role FROM users INNER JOIN user_role ON users.user_role_id = user_role.user_role_id WHERE users.user_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setRole(new Role(rs.getInt(7), rs.getString(8)));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	@Override //TESTED
	public User getUserByUsername(String username) {
		
		Connection conn = ConnectionManager.getConnection();
		
		User user = new User();
		String query = "SELECT users.user_id, users.first_name, users.last_name, users.username, users.email, users.pass_word, user_role.user_role_id, user_role.user_role FROM users INNER JOIN user_role ON users.user_role_id = user_role.user_role_id WHERE users.username = ?";

		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setRole(new Role(rs.getInt(7), rs.getString(8)));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	@Override //TESTED
	public ArrayList<User> getUsersByAccountId(int accountId) {
		
		Connection conn = ConnectionManager.getConnection();
		
		ArrayList<User> userList = new ArrayList<User>();
		
		String query = "SELECT users.user_id, users.first_name, users.last_name, users.username, users.email, users.pass_word, user_role.user_role_id, user_role.user_role FROM accounts_users INNER JOIN users ON accounts_users.user_id = users.user_id INNER JOIN user_role ON users.user_role_id = user_role.user_role_id WHERE accounts_users.account_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, accountId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				userList.add(new User(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						new Role(rs.getInt(7), rs.getString(8))));
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userList;
	}

	@Override //TESTED 
	public ArrayList<User> getAllUsers() {
		
		Connection conn = ConnectionManager.getConnection();
		
		ArrayList<User> userList = new ArrayList<User>();
		String query = "SELECT users.user_id, users.first_name, users.last_name, users.username, users.email, users.pass_word, user_role.user_role_id, user_role.user_role FROM users INNER JOIN user_role ON users.user_role_id = user_role.user_role_id ORDER BY users.user_id ASC";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				userList.add(new User(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						new Role(rs.getInt(7), rs.getString(8))));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override //TESTED
	public void updateUser(User currentUser) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "UPDATE users SET first_name = ?, last_name = ?, username = ?, email = ?, pass_word = ?, user_role_id = ? WHERE user_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, currentUser.getFirstName());
			pst.setString(2, currentUser.getLastName());
			pst.setString(3, currentUser.getUsername());
			pst.setString(4, currentUser.getEmail());
			pst.setString(5, currentUser.getPassword());
			pst.setInt(6, currentUser.getRole().getRoleId());
			pst.setInt(7, currentUser.getUserId());
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override //TESTED
	public void deleteUserById(int userId) {
		
		Connection conn = ConnectionManager.getConnection();

		String query = "DELETE FROM users WHERE user_id = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, userId);
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	@Override //TESTED
	public ArrayList<String> getAllUsernames() {
		
		Connection conn = ConnectionManager.getConnection();

		ArrayList<String> usernameList = new ArrayList<String>();
		
		String query = "SELECT username FROM users";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				usernameList.add(rs.getString(1));
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return usernameList;
	}

	@Override
	public boolean doesUserExist(String username, String password) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "SELECT * FROM users WHERE username = ? AND pass_word = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				String resultUsername = rs.getString("username");
				String resultPassword = rs.getString("pass_word");
				
				if(resultUsername.equals(username) && resultPassword.equals(password)) {
					return true;
				}
				return false;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	

}
