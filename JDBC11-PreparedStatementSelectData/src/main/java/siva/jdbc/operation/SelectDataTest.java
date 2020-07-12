package siva.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SelectDataTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		String sqlQuery = "SELECT * FROM STUDENT";

		Connection connection = null;

		Class.forName(driverClass);
		connection = DriverManager.getConnection(url, username, password);

		PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);

		ResultSet resultSet = prepareStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println(
					resultSet.getInt("sid") + "." + resultSet.getString("sname") + "-" + resultSet.getDouble("sfee"));
		}

		connection.close();

	}

}
