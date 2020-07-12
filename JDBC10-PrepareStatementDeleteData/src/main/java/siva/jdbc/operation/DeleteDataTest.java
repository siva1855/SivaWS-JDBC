package siva.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteDataTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		String sqlQuery = " DELETE FROM STUDENT ";

		Connection connection = null;

		Class.forName(driverClass);
		connection = DriverManager.getConnection(url, username, password);

		PreparedStatement preparedStatement = null;

		System.out.println("---------------------------");
		System.out.println("----MENU----");
		System.out.println("0,Delete All Students");
		System.out.println("1,Delete All By ID");
		System.out.println("2,Delete All By Name");
		System.out.println("3,Delete All By Fee");
		System.out.println("---------------------------");

		Scanner scanner = new Scanner(System.in);

		System.out.println("enter your option");

		int option = scanner.nextInt();

		switch (option) {
		case 1:
			sqlQuery += "WHERE SID=?";
			System.out.println("enter student Id :");
			int studentId = scanner.nextInt();
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, studentId);
			break;
		case 2:
			sqlQuery += "WHERE SNAME=?";
			System.out.println("enter student name :");
			String studentName = scanner.next();
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(2, studentName);
			break;
		case 3:
			sqlQuery += "WHERE SFEE=?";
			System.out.println("enter student fee :");
			Double studentFee = scanner.nextDouble();
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setDouble(3, studentFee);
			break;
		default:
			preparedStatement = connection.prepareStatement(sqlQuery);
			System.out.println("you choosen all row deleted");
			break;

		}
		int count = preparedStatement.executeUpdate();
		if (count == 0) {
			System.out.println("Sorry Records not found");
		} else {
			System.out.println("Record deleted successfully ");
		}
		connection.close();

	}

}
