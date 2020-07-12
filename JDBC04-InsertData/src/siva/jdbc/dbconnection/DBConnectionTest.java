package siva.jdbc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import siva.jdbc.operation.InsertData;

public class DBConnectionTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		InsertData insertData = new InsertData();

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Sucessfully DB Connected");

		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(insertData.getSqlQuery());

		System.out.println("Inserted Data :: " + count);

		connection.close();
		System.out.println(connection.isClosed());

	}

}
