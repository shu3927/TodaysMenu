package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserCheckDao;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();

		// Daoからユーザー情報を取得
		List<UserBean> userList = UserCheckDao.selectAll();

		// test用のコンソール出力
		System.out.println(name);
		System.out.println(pass);

		// jspで表示するエラーメッセージ用の変数を定義
		String loginErrorMsg = null;
		// 画面遷移時のURLを格納する変数を定義
		String url = null;

		// データを照合し、nameとpassが一致したときtrueを返す。
		for (UserBean ub : userList) {
			if (ub.getUserName().equals(name) && ub.getPassword().equals(pass)) {
				System.out.println("マッチしたユーザーを発見");
				UserBean user = new UserBean(ub.getUserId(), ub.getUserName(), ub.getPassword());
				// セッションにuser(ユーザー情報)を格納
				session.setAttribute("user", user);
				System.out.println(user); // 確認用

				// ログイン成功、セッション状態を保持する
				session.setAttribute("logIn", true);
				System.out.println("ログイン成功したよ");

				// 次の画面のURLを変数に格納
				url = "WEB-INF/jsp/Start.jsp";

				break; // マッチしたユーザーが見つかればループを終了
			} else if (ub.getUserName().equals(name)) {
				loginErrorMsg = "パスワードが間違っています。";
				url = "WEB-INF/jsp/Login.jsp";
				break;
			} else if (ub.getPassword().equals(pass)) {
				loginErrorMsg = "ニックネームが間違っています。";
				url = "WEB-INF/jsp/Login.jsp";
				break;
			} else {
				loginErrorMsg = "このユーザーは登録されていません。";
				url = "WEB-INF/jsp/Login.jsp";
			}
		}

		session.setAttribute("loginErrorMsg", loginErrorMsg);
//		System.out.println(loginErrorMsg);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
