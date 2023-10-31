package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.LikeBean;
import manager.DBManager;

public class LikeDao {

	// like_tbテーブルを全件取得
	public static List<LikeBean> selectAll(int userId) throws ClassNotFoundException, SQLException {

		// DB接続してSQL文を実行→表をresultsetに入れる
		Connection con = DBManager.getConnection();
		String sql = "select * from like_tb where userId = ?;";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();

		System.out.println("DBconnected");// 確認用

		// resultsetに入れた表をbeanに格納
		List<LikeBean> list = new ArrayList<LikeBean>();
		while (rs.next()) {
			LikeBean lb = new LikeBean();
			lb.setUserId(rs.getString("userId"));
			lb.setCookId(rs.getString("cookId"));
			lb.setLike(rs.getString("likes"));

			list.add(lb);

		}

		System.out.println("Listcreated");// 確認用

		return list;

	}

	// お気に入りを追加するためのDAO
	public static void insertLike(String userId, String cookId) throws SQLException, ClassNotFoundException {
		Connection con = DBManager.getConnection();
		// プレースホルダを利用してSQL文実行
		String sql = "insert into like_tb(userId,cookId,likes) values(?,?,true)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, userId);
		stmt.setString(2, cookId);

		stmt.executeUpdate();

	}

	// お気に入りを削除するためのDAO
	public static void deleteLike(String userId, String cookId) throws ClassNotFoundException, SQLException {
		Connection con = DBManager.getConnection();
		// プレースホルダを利用してSQL文実行
		String sql = "DELETE FROM like_tb WHERE userId = ? AND cookId = ?;";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, userId);
		stmt.setString(2, cookId);

		stmt.executeUpdate();
	}

}