package com.application.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/se_p566";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "mechanical";
	public static volatile Connection con = null;
	
	private DBConnection(){}
	
	private static Connection getConn() {
		
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			con = null;
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static Connection getConnection() {
		
		if(con == null) {
			synchronized(Connection.class) {
				if(con == null) {
					return getConn();
				}
			}
		}
		synchronized(Connection.class) {
			try {
				if(con.isValid(10)) {
					return con;
				}
				return getConn();
			} catch(Exception e) {
				e.printStackTrace();
				try {
					if(con != null) {
						con.close();
					}
				} catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
		return con;
	}
}
