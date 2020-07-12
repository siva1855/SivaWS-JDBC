package siva.jdbc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class UpdateTest {

	public static void main(String[] args)throws Exception {
		
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";
		
		String sqlQuery = "UPDATE STUDENT SET SNAME='CHERRY',SFEE=500.0 WHERE SID=1";

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Sucessfully DB Connected");

		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(sqlQuery);

		System.out.println("Updated Data :: " + count);

		connection.close();
		

	}

}
