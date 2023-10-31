package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manager.DBManager;

//ユーザー退会のためのDAO
public class UserDeleteDao {

	// 引数にはユーザーネームとパスワードを入れる
	public static void delete(String name, String pass) throws SQLException, ClassNotFoundException {
		Connection con = DBManager.getConnection();
		// プレースホルダを利用してSQL文実行
		String sql = "DELETE FROM user WHERE userName = ? AND PASSWORD = ?;";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, pass);

		stmt.executeUpdate();
	}

}
