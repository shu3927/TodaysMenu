package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserCheckDao;
import dao.UserEntryDao;

/**
 * Servlet implementation class Useregistration
 */
@WebServlet("/Useregistration")
public class Useregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String pass = request.getParameter("password");

		// jspで表示するエラーメッセージ用の変数を定義
		String registerErrorMsg = null;
		// 画面遷移時のURLを格納する変数を定義
		String url = null;

		// 登録されているユーザーの全件リストを持ってくる
		List<UserBean> userList = UserCheckDao.selectAll();

		if ((name == null) && (pass == null)) {

			registerErrorMsg = "文字を入力してください";
			url = "WEB-INF/jsp/Useregistration.jsp";

		} else {
			// ユーザーリストと入力情報を比較し、一致したものがない場合のみ登録DAOを呼び出す
			for (UserBean ub : userList) {
				if (ub.getUserName().equals(name) && ub.getPassword().equals(pass)) {
//				System.out.println("マッチしたユーザーを発見");
					// エラーメッセージを格納
					registerErrorMsg = "このユーザーは既に登録されています。";
					// 次の画面のURLを変数に格納
					url = "WEB-INF/jsp/Useregistration.jsp";
					// マッチしたユーザーが見つかればループを終了
					break;
				} else if (ub.getUserName().equals(name)) {
					registerErrorMsg = "この名前は使われています。";
					url = "WEB-INF/jsp/Useregistration.jsp";
					break;
				} else if (ub.getPassword().equals(pass)) {
					registerErrorMsg = "このパスワードは使われています。";
					url = "WEB-INF/jsp/Useregistration.jsp";
					break;
				}

			}
		}
		if (registerErrorMsg == null) {

			try {
				// ここで登録DAOを呼び出し
				UserEntryDao.user(name, pass);
			} catch (ClassNotFoundException | SQLException e) {
				request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
			}

			registerErrorMsg = "ユーザー登録が完了しました！";
			session.setAttribute("loginErrorMsg", registerErrorMsg);
			url = "WEB-INF/jsp/Login.jsp";
		}
		System.out.println(registerErrorMsg);
		session.setAttribute("registerErrorMsg", registerErrorMsg);
//		System.out.println(registerErrorMsg);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
