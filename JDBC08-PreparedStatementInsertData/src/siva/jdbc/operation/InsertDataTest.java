package siva.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDataTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		String sqlQuery = "INSERT INTO STUDENT VALUES(?,?,?)";

		Connection connection = null;

		Class.forName(driverClass);
		connection = DriverManager.getConnection(url, username, password);
		
		PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);
		
		prepareStatement.setInt(1, 3);
		prepareStatement.setString(2, "siva");
		prepareStatement.setDouble(3, 3000);
		
		int count = prepareStatement.executeUpdate();
		System.out.println("inserted Data ::" + count);
		
		connection.close();

	}

}
