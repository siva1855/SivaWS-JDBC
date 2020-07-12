package siva.jdbc.dbconnection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TestDBConnection {

	public static void main(String[] args) throws Exception {

		Properties properties = new Properties();
		FileReader fileReader = new FileReader("database.properties");
		properties.load(fileReader);

		String drivername = properties.getProperty("mysql.drivername");
		String url = properties.getProperty("mysql.url");
		String username = properties.getProperty("mysql.username");
		String password = properties.getProperty("mysql.password");
		
		Connection connnection = null;

		Class.forName(drivername);
		System.out.println("Driver has loaded");
		
		connnection = DriverManager.getConnection(url, username, password);
		System.out.println("DB has Connected");
		
		connnection.close();

	}

}
