package siva.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		String sqlQuery = "DELETE FROM STUDENT WHERE SID=6";

		Connection connection = null;
		Class.forName(driverClass);

		connection = DriverManager.getConnection(url, username, password);

		Statement statement = connection.createStatement();

		int count = statement.executeUpdate(sqlQuery);

		System.out.println("Deleted :: " + count);

		connection.close();
	}

}
