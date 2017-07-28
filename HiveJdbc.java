/* Sample java code to test Hive jdbc connection 
*/
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class HiveJdbc {

	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
 
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
 
		Connection con = DriverManager.getConnection(
				"jdbc:hive://10.10.71.23:10000/default", "mapr", "mapr");
		Statement stmt = con.createStatement();
 
		String tableName = "test";
 
		// show tables
		String sql = "show tables '" + tableName + "'";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		if (res.next()) {
			System.out.println(res.getString(1));
		}
 
	    
		sql = "select * from " + tablename +" where id='1'";
		res = stmt.executeQuery(sql);
		// show tables
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1));
			System.out.println(res.getString(2));
			System.out.println(res.getString(3));
		}
		res.close();
		stmt.close();
		con.close();
	}
}
