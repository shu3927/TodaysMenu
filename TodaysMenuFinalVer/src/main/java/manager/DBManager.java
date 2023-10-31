package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB接続と切断のクラス
public class DBManager {
	private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/cook_db";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";

//	Connection con = null;
//	Statement stmt = null;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		System.out.println("接続完了しました");
		return con;
		// getConnectionメソッドを呼び出すとcook_dbに接続して接続情報をconに返す
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("conのDB切断");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
				System.out.println("stmtのDB切断");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				System.out.println("resultSetのDB切断");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}