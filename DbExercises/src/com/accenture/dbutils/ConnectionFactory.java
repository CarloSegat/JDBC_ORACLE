package com.accenture.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String ip = "172.16.94.62";
	
	public static Connection getConnection() {
		Connection conn = null;
	
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@" + ip  +":1521:xe","ot","yourpassword");
				//System.out.println("Connessione avvenuta!");
			} catch (SQLException e) {
				System.out.println("Errore di connessione: "+e.getMessage());
			} 
		
		return conn;
	}
}