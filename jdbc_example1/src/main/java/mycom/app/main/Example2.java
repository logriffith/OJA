package mycom.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example2 {

	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			//Step 1: Load/Register the Driver
			Class.forName("org.postgresql.Driver");
			System.out.println("The Driver was loaded");
			
			//Step 2 - Open Connection(url,username,password)
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = System.getenv("postgresUsername");//stored username as environment variable
			String password = System.getenv("postgresPassword");//stored password as environment variable
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("You are connected to database now");
			
			//Step 3 - Create Statement
			Statement statement = connection.createStatement();// DriverManager class implements Statement Interface
			String sql = "INSERT INTO test.characters_table VALUES (108, Lex Luthor, null)";
			System.out.println("Statement successfully created");
			
			//Step 4 - Execute Query
			int row = statement.executeUpdate(sql);
			System.out.println("The query was executed");
			
			//Step 5 - Process Results
			System.out.println("ID = ");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
