package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public final static String driverClass = "com.mysql.jdbc.Driver";
	public final static String url = "jdbc:mysql://localhost:3306/educational?useUnicode=true&characterEncoding=UTF-8";
	public final static String username = "root";
	public final static String password = "root"; 
	
	//public static Connection conn = null;
	static {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		//if(conn == null){
		Connection	conn = DriverManager.getConnection(url, username, password);
		//}
		return conn;
	}
}
