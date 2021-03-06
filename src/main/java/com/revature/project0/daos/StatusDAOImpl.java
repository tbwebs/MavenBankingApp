package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project0.models.Status;

public class StatusDAOImpl implements StatusDAO {

	@Override //TESTED
	public ArrayList<Status> getAllStatuses() {
		
		Connection conn = ConnectionManager.getConnection();
		
		ArrayList<Status> statusList = new ArrayList<Status>();
		String query = "SELECT * FROM account_status";
		
		try {
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("account_status_id");
				String status = rs.getString("account_status");
				
				statusList.add(new Status(id, status));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return statusList;
	}

	@Override //TESTED
	public void createStatus(Status status) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "INSERT INTO account_status(account_status) VALUES (?)";
			
		try {	
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, status.getStatus());
			
			ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
