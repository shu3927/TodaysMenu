package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manager.DBManager;

public class LikeDeleteDao {

	public static void likeDelete(String id) throws ClassNotFoundException, SQLException {
		
		Connection con = DBManager.getConnection();
		int userId = Integer.parseInt(id);
		System.out.println(userId);
		// like_tbから現在のユーザーが登録しているお気に入り情報を削除
		String sql = "DELETE FROM like_tb WHERE userId = ?;";		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, userId);
		
		System.out.println(sql);
		stmt.executeUpdate();
	}
}
