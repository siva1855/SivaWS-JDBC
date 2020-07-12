package siva.jdbc.storeimage;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreImagesTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);
				
		String sqlQuery = "INSERT INTO IMAGES VALUES(?,?,?)";
		
		File file = new File("D:\\AdvancedJava\\Siva2.6Exp.docx");
		FileInputStream fileInputStream = new FileInputStream(file);

		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setString(2, "Resume.docx");
		preparedStatement.setBinaryStream(3, fileInputStream,(int)file.length());
		//preparedStatement.setBlob(3,fileInputStream);
		
		int count = preparedStatement.executeUpdate();
		if(count==0) {
			System.out.println("image not inserted");
		}else {
			System.out.println("image inserted");
		}
		
		
		connection.close();

	}

}
