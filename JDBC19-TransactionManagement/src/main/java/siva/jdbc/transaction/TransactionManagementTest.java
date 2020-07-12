package siva.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagementTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Connection connection = null;

		Class.forName(driverClass);
		connection = DriverManager.getConnection(url, username, password);

		// 1.disable auto commit(By default it is enabled)
		connection.setAutoCommit(false);

		Statement statement = connection.createStatement();

		try {
			statement.executeUpdate("insert into student values(8,'satya',80000)");
			connection.commit();
			System.out.println("Data has Inserted");
		} catch (SQLException e) {
			connection.rollback();
			System.out.println("Data Not Inserted " + e);
		} finally {
			connection.close();
		}
	}

}
