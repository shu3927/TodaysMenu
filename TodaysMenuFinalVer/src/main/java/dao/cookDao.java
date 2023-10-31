package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CookBean;
import manager.DBManager;

public class cookDao {

	// cook_db内のcookテーブルの情報をcookBeanのリストに格納
	public static List<CookBean> selectAll() throws ClassNotFoundException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<CookBean> list = null;

		try {
			// DB接続してSQL文を実行→表をresultsetに入れる
			con = DBManager.getConnection();
			String sql = "select * from cook;";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			System.out.println("DBconnected");// 確認用

			// resultsetに入れた表をbeanに格納
			list = new ArrayList<CookBean>();
			while (rs.next()) {
				CookBean cb = new CookBean();
				cb.setCookId(rs.getString("cookId"));
				cb.setGenreId(rs.getString("genreId"));
				cb.setCategoryId(rs.getString("categoryId"));
				cb.setFoodId(rs.getString("foodId"));
				cb.setCookName(rs.getString("cookName"));
				cb.setUrl(rs.getString("url"));
				cb.setLikes(0);

				list.add(cb);

				// list.add(new cookBean(rs.getString("cookId"), "唐揚げ", "URL~~~"));

			}
			System.out.println("Listcreated");// 確認用

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
			DBManager.close(stmt);
			DBManager.close(con);
		}

		return list;
	}

}
