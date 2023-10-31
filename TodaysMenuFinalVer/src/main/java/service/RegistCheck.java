package service;

import java.util.List;

import bean.UserBean;
import dao.UserCheckDao;
import dao.UserEntryDao;

public class RegistCheck {

	public static String registCheck(String name, String pass) {

		// 表示メッセージを格納する変数msgを用意
		String msg = "";

		if (name.equals("") || pass.equals("")) {

			msg = "文字の入力が必須です。";
		} else {

			// 登録予定ユーザーの情報と比較するため、一旦全てのユーザーデータを持ってくる
			List<UserBean> users = UserCheckDao.selectAll();

			// for文でリストと比較していく
			for (UserBean userBean : users) {
				// 名前とパスワードの両方が使用されている(既に登録されている)場合の登録をはじく
				if (userBean.getUserName().equals(name) && userBean.getPassword().equals(pass)) {

					msg = "このユーザーは既に登録されています。";
					break;

					// 名前が使用されている場合の登録をはじく
				} else if (userBean.getUserName().equals(name)) {

					msg = "この名前は使用されています。";
					break;

					// パスワードが使用されている場合の登録をはじく
				} else if (userBean.getPassword().equals(pass)) {

					msg = "このパスワードは使用されています。";
					break;

					// 名前もパスワードも登録されていない場合にユーザー情報を登録する為、チェック用の文字列を格納
				} else {

					msg = "regist";

				}

			}

			// 文字列でregistが返ってきた場合のみユーザー登録をし、表示用メッセージを書き換える
			if (msg.equals("regist")) {

				try {

					UserEntryDao.user(name, pass); // DAOを使用してデータベースにユーザー情報を登録
					msg = "ユーザーが正常に登録されました。";

				} catch (Exception e) {

					msg = "ユーザーの登録中にエラーが発生しました。";
				}

			}

		}

		return msg;
	}

}
