package siva.jdbc.cachedrowset;

import javax.sql.rowset.CachedRowSet;

import javax.sql.rowset.RowSetProvider;

public class CachedRowSetDataTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";
		Class.forName(driverClass);
		CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
		cachedRowSet.setUrl(url);
		cachedRowSet.setUsername(username);
		cachedRowSet.setPassword(password);

		cachedRowSet.setCommand("SELECT * FROM STUDENT");
		cachedRowSet.execute();
		while (cachedRowSet.next()) {
			System.out.println(
					cachedRowSet.getInt(1) + ". " + cachedRowSet.getString(2) + "--" + cachedRowSet.getDouble(3));
		}
	}

}
