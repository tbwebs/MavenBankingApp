package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static Connection connection;
	
	private static String connectionString = "jdbc:postgresql://heffalump.db.elephantsql.com:5432/btvmiven",
			username = "btvmiven",
			password = "RvhWr2rLT4shGYukK9OLn8lceKo0uDlP";
	
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(connectionString, username, password);
			}
			
			return connection;
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return null;
	}
}
