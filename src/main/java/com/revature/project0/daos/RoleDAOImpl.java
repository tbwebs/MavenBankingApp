package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.Role;

public class RoleDAOImpl implements RoleDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override //TESTED
	public ArrayList<Role> getAllRoles() {
		
		ArrayList<Role> rolesList = new ArrayList<Role>();
		String query = "SELECT * FROM user_role";
		
		try {
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("user_role_id");
				String role = rs.getString("user_role");
				
				rolesList.add(new Role(id, role));
				
			} return rolesList;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override //TESTED
	public void createRole(Role role) {
		
		try {
			
			String query = "INSERT INTO user_role(user_role) VALUES (?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, role.getRole());
			
			ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
