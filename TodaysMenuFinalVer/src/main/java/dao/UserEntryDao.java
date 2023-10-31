package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manager.DBManager;

//user登録のためのDAO
public class UserEntryDao {
	public static void user(String name, String pass) throws ClassNotFoundException, SQLException {

		Connection con = null;

		con = DBManager.getConnection();
		String sql = "INSERT INTO USER(userName, password) VALUES (?,?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, pass);

		// 更新処理(insert文)のSQLを実行
		stmt.executeUpdate();

	}
}
