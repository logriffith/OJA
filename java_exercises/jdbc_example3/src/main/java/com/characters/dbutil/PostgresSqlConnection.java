package com.characters.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSqlConnection {

	public static Connection connection; 
	
	private PostgresSqlConnection() {
		// Do not want to instantiate this class
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DbUtilProperties.DRIVER);//Loading the Driver
		//Opening the connection
		String url = DbUtilProperties.URL;
		String username = "postgres";
		String password = "Is40:31#protected!";
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
