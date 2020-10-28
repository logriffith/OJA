package mycom.app.main;

import java.sql.Connection;

public class Example2 {

	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			//Step 1: Load/Register the Driver
			Class.forName("org.postgresql.Driver");
			System.out.println("The ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
