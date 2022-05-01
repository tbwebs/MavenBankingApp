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
	public void createUser(User newUser) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "INSERT INTO users(username, pass_word, first_name, last_name, email, user_role_id) VALUES (?, ?, ?, ?, ?, ?)";
		int creationId = 0;
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, newUser.getUsername());
			pst.setString(2, newUser.getPassword());
			pst.setString(3, newUser.getFirstName());
			pst.setString(4, newUser.getLastName());
			pst.setString(5, newUser.getEmail());
			pst.setInt(6, newUser.getRole().getRoleId());
			
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override //TESTED
	public User getUserByUsername(String username) {
		
		Connection conn = ConnectionManager.getConnection();
		
		User user = new User();
		String query = "SELECT users.username, users.pass_word, users.first_name, users.last_name, users.email, user_role.user_role_id, user_role.user_role FROM users INNER JOIN user_role ON users.user_role_id = user_role.user_role_id WHERE users.username = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setRole(new Role(rs.getInt(6), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	@Override //TESTED
	public ArrayList<User> getUsersByAccountNumber(long accountNumber) {
		
		Connection conn = ConnectionManager.getConnection();
		
		ArrayList<User> userList = new ArrayList<User>();
		
		String query = "SELECT users.username, users.pass_word, users.first_name, users.last_name, users.email, user_role.user_role_id, user_role.user_role FROM accounts_users INNER JOIN users ON accounts_users.username = users.username INNER JOIN user_role ON users.user_role_id = user_role.user_role_id WHERE accounts_users.account_num = ? ORDER BY last_name ASC";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setLong(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				userList.add(new User(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						new Role(rs.getInt(6), rs.getString(7))));
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
		String query = "SELECT users.username, users.pass_word, users.first_name, users.last_name, users.email, user_role.user_role_id, user_role.user_role FROM users INNER JOIN user_role ON users.user_role_id = user_role.user_role_id ORDER BY last_name ASC";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				userList.add(new User(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						new Role(rs.getInt(6), rs.getString(7))));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override //TESTED
	public void updateUser(User currentUser) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "UPDATE users SET pass_word = ?, first_name = ?, last_name = ?, email = ?, user_role_id = ? WHERE username = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, currentUser.getPassword());
			pst.setString(2, currentUser.getFirstName());
			pst.setString(3, currentUser.getLastName());
			pst.setString(4, currentUser.getEmail());
			pst.setInt(5, currentUser.getRole().getRoleId());
			pst.setString(6, currentUser.getUsername());
			pst.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override //TESTED
	public void deleteUserByUsername(String username) {
		
		Connection conn = ConnectionManager.getConnection();

		String query = "DELETE FROM users WHERE username = ?";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
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
		
		String query = "SELECT username, pass_word FROM users WHERE username = ? AND pass_word = ?";
		
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
