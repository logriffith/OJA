package mycom.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleJDBC {

	public static void main(String[] args) {
		Connection firstConnection=null;
		try {
			//Step 1 - Load/Register the Driver
			Class.forName("org.postgresql.Driver");//Driver class name is found in Driver Manager in DBeaver
			System.out.println("Driver loaded successful!");
			
			//Step 2 - Open Connection(url,username,password)
			//url is found in Edit Driver as jdbc:postgresql://{host}[:{port}]/[{database}]
			//change host to localhost and port to the default port in window and DB to postgres
			//thus
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "Is40:31#protected!";
			firstConnection = DriverManager.getConnection(url, username, password);
			System.out.println("You are connected to database now");
			
			//Step 3 - Create Statement
			Statement statement = firstConnection.createStatement();// DriverManager class implements Statement Interface
			String sql = "SELECT id, occupation, email, phone_number, status from test.employees";
			System.out.println("Statement successfully created");
			
			//Step 4 - Execute Query
			//Since I and using DQL, I need the executeQuery() method, which is in the ResultSet interface
			ResultSet result = statement.executeQuery(sql);
			System.out.println("The query was executed");
			
			//Step 5 - Process Results
			while(result.next()) {
				System.out.print("ID = "+result.getInt("id")+ " ");
				System.out.print("Occupation = "+result.getString("occupation")+ " ");
				System.out.print("Email = "+result.getString("email")+ " ");
				System.out.print("Phone Number = "+result.getString("phone_number")+ " ");
				System.out.println("Status = "+result.getString("status")+ " ");
			}
			System.out.println("\nResults were processed");
			
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println(e);
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				//Step 6 - Close Connection
				firstConnection.close();
				System.out.println("Your connection is now closed");
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println(e);
			}
		}
	}

}
