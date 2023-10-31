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

@WebServlet("/DeleteLikeServ")
public class DeleteLikeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//現在ログイン中のユーザーIDを取得するため、ユーザーインスタンスをセッションから取得
		UserBean user = (UserBean) session.getAttribute("user");
		//選択されたレシピのIDを取得する
		String cookId = request.getParameter("cookId");
		
		//お気に入り登録解除用のメソッドを呼び出す
		try {
			LikeDao.deleteLike(user.getUserId(), cookId);
		} catch (ClassNotFoundException | SQLException e) {
			request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
		}}

}
