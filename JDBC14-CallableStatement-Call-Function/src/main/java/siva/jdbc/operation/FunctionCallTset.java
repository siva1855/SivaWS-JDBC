package siva.jdbc.operation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class FunctionCallTset {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);

		String sqlQuery = "{?=call function_getstudentname(?)}";

		CallableStatement callableStatement = connection.prepareCall(sqlQuery);

		callableStatement.registerOutParameter(1, Types.VARCHAR);
		callableStatement.setInt(2, 3);

		callableStatement.execute();

		String stdName = callableStatement.getString(1);
		if (stdName == null) {
			System.out.println("Not found student");
		} else {
			System.out.println("Student Name :: " + stdName);
		}

		connection.close();
	}

}
