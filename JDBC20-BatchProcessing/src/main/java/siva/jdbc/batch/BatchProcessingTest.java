package siva.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingTest {

	public static void main(String[] args) throws Exception {
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Connection connection = null;

		Class.forName(driverClass);
		connection = DriverManager.getConnection(url, username, password);

		// disable auto commit(By default it is enabled)
		connection.setAutoCommit(false);

		Statement statement = connection.createStatement();

		try {

			statement.addBatch("INSERT INTO EMPLOYEE VALUES(1,'SIVA',1000)");
			statement.addBatch("INSERT INTO EMPLOYEE VALUES(2,'CHERRY',2000)");
			statement.addBatch("INSERT INTO EMPLOYEE VALUES(3,'MILKY',3000)");
			statement.addBatch("INSERT INTO EMPLOYEE VALUES(4,'PRAVEEN',4000)");
			
			statement.addBatch("UPDATE EMPLOYEE SET ENAME='ANJI',ESAL=5000.0 WHERE EID=4");

			statement.addBatch("DELETE FROM EMPLOYEE WHERE EID=6");

			int[] count = statement.executeBatch();
			System.out.println(count[0]);
			System.out.println(count[1]);
			System.out.println(count[2]);
			System.out.println(count[3]);
			System.out.println(count[4]);
			System.out.println(count[5]);

			connection.commit();
			System.out.println("Total Recorded are Inserted");
		} catch (SQLException e) {
			connection.rollback();
			System.out.println("Records are not Inserted " + e);
		} finally {
			connection.close();
		}
	}

}
