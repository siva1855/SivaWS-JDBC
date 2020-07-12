package siva.jdbc.operation;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetImageTest {

	public static void main(String[] args) throws Exception {
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);

		String sqlQuery = "SELECT * FROM IMAGES WHERE ID=?";

		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, 2);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Blob image = resultSet.getBlob(3);
			byte[] byteArrayObject = image.getBytes(1, (int) image.length());
			FileOutputStream fileOutputStream = new FileOutputStream("D:\\AdvancedJava\\GetFile");
			     //we can give any extension name
			//FileOutputStream fileOutputStream = new FileOutputStream("D:\\AdvancedJava\\GetFile.jpg");
			fileOutputStream.write(byteArrayObject);
			fileOutputStream.flush();
			fileOutputStream.close();
			System.out.println("Downloaded Image");
		} else {
			System.out.println("Image Not found with this given ID");
		}
		connection.close();
	}

}
