package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TodaysMenuRollingServ
 */
@WebServlet("/TodaysMenuRollingServ")
public class TodaysMenuRollingServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ここから始める！！！！！！！！！
		HttpSession session = request.getSession(); // セッションの新規取得
		String msg = "";
		session.setAttribute("loginErrorMsg", msg);
		request.getRequestDispatcher("WEB-INF/jsp/RollingLogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
