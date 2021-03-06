package utils;
/***
 * @author 15185丁硕
 * 数据库连接工具包
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	static String rootName="ds";
	static String rootPwd="root";
	static String DBName="user2";
	static String DBIP="192.168.66.129";
	//本地电脑的虚拟服务器,可如若上传至服务器,请使用localhost
	static String DBIP2="localhost";
	static String DBIP3="172.17.16.6";
	static String DBLink="jdbc:mysql://"+DBIP+":3306/";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return getConnectionFirst(rootName,rootPwd,DBName);
	}
	public static Connection getConnectionFirst(String rootName,String rootPwd,String DataBaseName ) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DBLink + DataBaseName 
					+ "?useUnicode=true&characterEncoding=utf-8&useSSL=false",
					rootName, rootPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(Connection conn, PreparedStatement ps, ResultSet res) {
		try {
			if (res != null) {
				res.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

