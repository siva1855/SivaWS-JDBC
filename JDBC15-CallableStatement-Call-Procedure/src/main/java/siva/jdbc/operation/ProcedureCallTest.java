package siva.jdbc.operation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcedureCallTest {

	public static void main(String[] args) {
		// String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		String sqlQuery = "{call procedure_getstudentname(?,?,?)}";
		
		// Java 1.7V try with multiple resoprces
		//it is autoclosable resources
		try (Connection connection = DriverManager.getConnection(url, username, password);
				CallableStatement callableStatement = connection.prepareCall(sqlQuery)) {

			callableStatement.setInt(1, 3);
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.registerOutParameter(3, Types.DOUBLE);

			callableStatement.execute();

			System.out.println("Student Name :: " + callableStatement.getString(2));
			System.out.println("Student Fee :: " + callableStatement.getDouble(3));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
