package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.LikeDao;

@WebServlet("/InsertLikeServ")
public class InsertLikeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/LikeAttention.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// 現在ログイン中のユーザーIDを取得するため、ユーザーインスタンスをセッションから取得
		UserBean user = (UserBean) session.getAttribute("user");
		System.out.println(user);

		// 選択されたレシピのIDを取得する
		String cookId = request.getParameter("cookId");

		// ゲストログイン時にボタンが押された場合、登録を促すページに飛ばす…ためのURL情報をレスポンスする
		if (user == null) {
			System.out.println("ここまで到達してる");
			// レスポンスステータスを送信
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//					request.getRequestDispatcher("WEB-INF/jsp/LikeAttention.jsp").forward(request, response);
//					response.sendRedirect("WEB-INF/jsp/LikeAttention.jsp");
			System.out.println("リクエスト送れたよ");
		} else {
			// ユーザーがnullでないとき、お気に入り登録用のメソッドを呼び出す
			try {
				LikeDao.insertLike(user.getUserId(), cookId);
				response.setStatus(HttpServletResponse.SC_OK);
			} catch (ClassNotFoundException | SQLException e) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
		System.out.println("ここ");
//		request.getRequestDispatcher("WEB-INF/jsp/LikeAttention.jsp").forward(request, response);

	}

}