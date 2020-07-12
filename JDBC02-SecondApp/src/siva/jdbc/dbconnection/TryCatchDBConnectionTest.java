package siva.jdbc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TryCatchDBConnectionTest {

	public static void main(String[] args) {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Connection connection = null;

		try {
			Class.forName(driverClass);
			System.out.println("Driver Calss Loaded");

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("DB has connected");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (connection != null)
					connection.close();
				System.out.println("close resources");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Good Bye");
	}

}
