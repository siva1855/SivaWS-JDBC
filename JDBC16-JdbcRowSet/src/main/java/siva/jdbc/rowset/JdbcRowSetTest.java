package siva.jdbc.rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest {

	public static void main(String[] args) throws Exception {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sivajdbcdb";
		String username = "root";
		String password = "root";

		Class.forName(driverClass);
		JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
		jdbcRowSet.setUrl(url);
		jdbcRowSet.setUsername(username);
		jdbcRowSet.setPassword(password);

		jdbcRowSet.setCommand("SELECT * FROM STUDENT");
		jdbcRowSet.execute();

		System.out.println("CHECK CURSOR POSITION");
		boolean first = jdbcRowSet.isBeforeFirst();
		System.out.println(first);
		boolean last = jdbcRowSet.isAfterLast();
		System.out.println(last);
		System.out.println("................");
		
		System.out.println("MOVE FORWARD");
		while (jdbcRowSet.next()) {
			System.out.println(jdbcRowSet.getInt(1) + ". " + jdbcRowSet.getString(2) + "--" + jdbcRowSet.getDouble(3));

		}
		System.out.println("................");
		System.out.println("MOVE BACKWARD");
		while (jdbcRowSet.previous()) {
			System.out.println(jdbcRowSet.getInt(1) + ". " + jdbcRowSet.getString(2) + "--" + jdbcRowSet.getDouble(3));
		}
		System.out.println("................");
		System.out.println("MOVE TO 2ND ROW");
		jdbcRowSet.absolute(2);
		System.out.println(jdbcRowSet.getInt(1) + ". " + jdbcRowSet.getString(2) + "--" + jdbcRowSet.getDouble(3));
		
		System.out.println("................");
		System.out.println("MOVE ONE ROW BACK");
		jdbcRowSet.relative(-1);
		System.out.println(jdbcRowSet.getInt(1) + ". " + jdbcRowSet.getString(2) + "--" + jdbcRowSet.getDouble(3));
		
		System.out.println("................");
		System.out.println("GO TO FIRST ROW");
		jdbcRowSet.first();
		System.out.println(jdbcRowSet.getInt(1) + ". " + jdbcRowSet.getString(2) + "--" + jdbcRowSet.getDouble(3));
		
		System.out.println("................");
		System.out.println("GO TO LAST ROW");
		jdbcRowSet.last();
		System.out.println(jdbcRowSet.getInt(1) + ". " + jdbcRowSet.getString(2) + "--" + jdbcRowSet.getDouble(3));
		jdbcRowSet.close();
		
	}

}
