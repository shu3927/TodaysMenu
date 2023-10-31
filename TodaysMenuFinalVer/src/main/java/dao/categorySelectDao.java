package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CookBean;
import manager.DBManager;

public class categorySelectDao {

	public static List<CookBean> selectCategory() {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<CookBean> list = null;

		try {
			con = DBManager.getConnection();
			String sql = "select * from cook where categoryId = 1";
			stmt = con.prepareStatement(sql);
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
				list.add(cb);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
