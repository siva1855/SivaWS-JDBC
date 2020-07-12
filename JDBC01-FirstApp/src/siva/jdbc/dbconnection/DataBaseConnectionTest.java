package siva.jdbc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnectionTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println(connection);
		System.out.println("Sucessfully Connected");
		connection.close();
		System.out.println(connection.isClosed());
	}

}
