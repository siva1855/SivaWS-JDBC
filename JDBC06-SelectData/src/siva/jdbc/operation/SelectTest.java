package siva.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) throws Exception {
		/*
		 * In new JDBC API(4.x)It supports auto-loading of driver class i.e. without
		 * even step#1 in JDBC program works.
		 */
		
		// String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		String sqlQuery = "SELECT * FROM STUDENT";

		Connection connection = null;

		// Class.forName(driverClass);
		connection = DriverManager.getConnection(url, username, password);

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sqlQuery);

		while (resultSet.next()) {
			System.out.println(
					resultSet.getInt("sid") + ". " + resultSet.getString("sname") + "-" + resultSet.getDouble("sfee"));
		}
		connection.close();

	}

}
