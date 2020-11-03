package com.employee.search.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSqlConnection {
	
	public static Connection connection;
	
	private PostgresSqlConnection() {//constructor is private so the class cannot be instantiated
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//Step 1 - Load/Register the Driver
		Class.forName(DbUtilInfo.DRIVER);
		//Step 2 - Open Connection(url,username,password)
		String url = DbUtilInfo.URL;
//		String username = System.getenv("postgresUsername");
//		String password = System.getenv("postgresPassword");
		String username = "postgres";
		String password = "Is40:31#protected!";
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
//Single Ton - Single TON Java CLass.