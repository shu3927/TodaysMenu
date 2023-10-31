package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;

/**
 * Servlet implementation class GuestLoginServ
 */
@WebServlet("/GuestLoginServ")
public class GuestLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// 空のユーザー情報を作成
		UserBean user = null;
		// セッションに空のユーザー情報をセット
		session.setAttribute("user", user);
		System.out.println(user); // 確認用
		// スタートページに遷移
		request.getRequestDispatcher("WEB-INF/jsp/Start.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
