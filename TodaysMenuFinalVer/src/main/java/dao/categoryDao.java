package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.SubTableBean;
import manager.DBManager;

public class categoryDao {

	public static List<SubTableBean> selectAll() {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<SubTableBean> list = null;

		try {
			// DB接続とSQL文を実行
			con = DBManager.getConnection();
			String sql = "select * from category;";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			// resultsetに入れた表をリストに入れる
			list = new ArrayList<SubTableBean>();
			while (rs.next()) {
				SubTableBean sub = new SubTableBean();
				sub.setId(rs.getString("categoryId"));
				sub.setName(rs.getString("categoryName"));
				list.add(sub);
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
