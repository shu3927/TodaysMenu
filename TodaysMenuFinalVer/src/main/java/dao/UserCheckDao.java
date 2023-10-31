package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.UserBean;
import manager.DBManager;

//ユーザーログインの際確認する時使用するDAO
public class UserCheckDao {

	// userテーブルを取得
	public static List<UserBean> selectAll() {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<UserBean> list = null;

		try {
			// DB接続してSQL文を実行→表をresultsetに入れる
			con = DBManager.getConnection();
			String sql = "select * from user;";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			System.out.println("DBconnected");// 確認用

			// resultsetに入れた表をbeanに格納
			list = new ArrayList<UserBean>();
			while (rs.next()) {
				UserBean cb = new UserBean();
				cb.setUserId(rs.getString("userId"));
				cb.setUserName(rs.getString("userName"));
				cb.setPassword(rs.getString("password"));

				list.add(cb);

			}

			System.out.println("Listcreated");// 確認用

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
			DBManager.close(stmt);
			DBManager.close(con);
		}

//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i).getUserName() + " ");
//			System.out.println(list.get(i).getPassword());
//		}

		return list;
	}

}
