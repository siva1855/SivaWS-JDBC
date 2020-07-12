package siva.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		String sqlQuery = "UPDATE STUDENT SET SNAME=?,SFEE=? WHERE SID=?";

		Connection connection = null;

		Class.forName(driverClass);
		connection = DriverManager.getConnection(url, username, password);

		PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);

		Scanner scanner = new Scanner(System.in);

		System.out.println("enter sname : ");
		String studentName = scanner.next();

		System.out.println("enter sfee");
		Double studentFee = scanner.nextDouble();

		System.out.println("enter sid : ");
		int studentId = scanner.nextInt();

		prepareStatement.setString(1, studentName);
		prepareStatement.setDouble(2, studentFee);
		prepareStatement.setInt(3, studentId);

		int count = prepareStatement.executeUpdate();

		if (count == 0) {
			System.out.println("No rows Updated");
		} else {
			System.out.println("rows updated");
			System.out.println("Updated Count : " + count);
		}

		connection.close();
	}

}
