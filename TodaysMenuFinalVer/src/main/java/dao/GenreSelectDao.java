package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CookBean;
import manager.DBManager;

//絞り込み用Daoにする
public class GenreSelectDao {
	public static List<CookBean> selectGenre(String selected, String id) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<CookBean> list = null;

		try {
			con = DBManager.getConnection();
			String sql = null;

			switch (selected) {
			case "genre":
				sql = "SELECT * FROM cook WHERE genreId = ? ;";
				break;
			case "category":
				sql = "SELECT * FROM cook WHERE categoryId = ? ;";
			}
			// String sql = "SELECT * FROM cook WHERE " + selected + "Id = " + id + ";";
			// String sql = "SELECT * FROM cook WHERE " + selected + "Id = ? ;";

			stmt = con.prepareStatement(sql);
			// stmt.setString(1, selectId);
			stmt.setString(1, id);
			System.out.println(sql);
			rs = stmt.executeQuery();

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
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
			DBManager.close(stmt);
			DBManager.close(con);

		}

		return list;
	}

}
