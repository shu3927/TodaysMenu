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
import dao.LikeDeleteDao;
import dao.UserDeleteDao;

/**
 * Servlet implementation class WithdrawalServ
 */
@WebServlet("/WithdrawalServ")
public class WithdrawalServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// セッションからユーザーオブジェクトを取得
		UserBean user = (UserBean) session.getAttribute("user");

		// ユーザー情報消去用のDAOを呼び出し
		try {

			System.out.println(user.getUserId());
			LikeDeleteDao.likeDelete(user.getUserId());
			UserDeleteDao.delete(user.getUserName(), user.getPassword());
			request.getRequestDispatcher("html/ConfirmWithdrawal.html").forward(request, response); // ここに退会しましたよ～ページのURL入れる

		} catch (ClassNotFoundException | SQLException e) {

			request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
		}
	}

}
