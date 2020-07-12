package siva.jdbc.webrowset;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetDataTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Class.forName(driverClass);

		WebRowSet webRowSet = RowSetProvider.newFactory().createWebRowSet();
		webRowSet.setUrl(url);
		webRowSet.setUsername(username);
		webRowSet.setPassword(password);
		webRowSet.setCommand("SELECT * FROM STUDENT");
		
		webRowSet.execute();

		System.out.println("------DATA--------");
		while (webRowSet.next()) {
			System.out.println(webRowSet.getInt(1) + ". " + webRowSet.getString(2) + "--" + webRowSet.getDouble(3));
		}
		System.out.println();
		System.out.println("------DATA XML FORMAT--------");
		webRowSet.writeXml(System.out);
		webRowSet.close();
	}
}
