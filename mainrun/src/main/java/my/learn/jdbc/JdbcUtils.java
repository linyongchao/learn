package my.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import my.learn.property.JdbcProperty;

/**
 * 数据库操作工具类
 * 
 * @author lin
 * @date 2018年2月5日 下午3:33:03
 */
public class JdbcUtils {
	/**
	 * 获取连接
	 * 
	 * @return
	 * @author lin
	 * @date 2018年2月5日 下午3:33:18
	 */
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://" + JdbcProperty.IP + ":" + JdbcProperty.PORT + "/" + JdbcProperty.DBNAME + "?user="
				+ JdbcProperty.USERNAME + "&password=" + JdbcProperty.PASSWORD
				+ "&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 * @author lin
	 * @date 2018年2月5日 下午3:33:47
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
