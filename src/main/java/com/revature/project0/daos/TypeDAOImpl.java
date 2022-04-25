package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.revature.project0.models.Type;

public class TypeDAOImpl implements TypeDAO{

	private Connection conn = ConnectionManager.getConnection();
	
	@Override //NEED TO TEST
	public ArrayList<Type> getAllTypes() {
		
		ArrayList<Type> typeList = new ArrayList<Type>();
		String query = "SELECT * FROM account_type";
		
		try {
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("account_type_id");
				String type = rs.getString("account_type");
				
				typeList.add(new Type(id, type));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return typeList;

	}

	@Override //NEED TO TEST
	public void createType(Type type) {
		
		String query = "INSERT INTO account_type(account_type) VALUES (?)";
		
		try {	
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, type.getType());
			
			ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
