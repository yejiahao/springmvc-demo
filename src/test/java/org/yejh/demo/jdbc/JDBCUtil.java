package org.yejh.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCUtil {
	private JDBCUtil() {
		throw new AssertionError();
	}

	public static Connection getConnection(String url, String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void getResultSet(Connection conn, String sql) {
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			System.out.println("------------------------");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1) + "\t" + rsmd.getColumnName(2) + "\t" + rsmd.getColumnName(3));
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstat != null) {
					pstat.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/springmvcdemo";
		String user = "root";
		String password = "";
		String sql = "SELECT * FROM user_info";
		Connection conn = JDBCUtil.getConnection(url, user, password);
		JDBCUtil.getResultSet(conn, sql);
		System.out.println("test end.");
	}
}
