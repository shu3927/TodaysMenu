package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CookBean;
import bean.LikeBean;
import bean.SubTableBean;
import bean.UserBean;
import dao.GenreSelectDao;
import dao.LikeDao;
import service.LikeAddCook;

/**
 * Servlet implementation class GenreServlet
 */
@WebServlet("/GenreServlet")
public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// スコープの中のselectedを取得してselectedに代入。中身はジャンルと仮定
		String selected = (String) session.getAttribute("selected");
		// jspで書いたインプットタグのセレクトを取ってきている。値はジャンルID。
		String selectId = request.getParameter("select");
		int id = 0;

		// ルーレットが回された時にランダムが送られてくるので、そのランダム機能を実装
		if (selectId == null) {

			request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
		} else if (selectId.equals("random")) {

			List<SubTableBean> subValue = (List<SubTableBean>) session.getAttribute("subs");
			id = new Random().nextInt(subValue.size()) + 1;

		} else {

			try {
				id = (Integer.parseInt(selectId));
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
			}
		}
		System.out.println(selected);
		System.out.println(String.valueOf(id));
		List<CookBean> cooks = GenreSelectDao.selectGenre(selected, String.valueOf(id));
		// ここでLikeDaoとLikeAddCookクラスを呼び出して、cookリストにお気に入り情報を付与
		// ユーザー情報を付与したいので、セッションからユーザーを取得
		UserBean user = (UserBean) session.getAttribute("user");

		List<LikeBean> likes = null;
		if (user != null) {
			try {
				likes = LikeDao.selectAll(Integer.parseInt(user.getUserId()));
				cooks = LikeAddCook.likeAddCook(likes, cooks);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
			}
		}
		// !! beanからcooksに変更しました !!
		session.setAttribute("cooks", cooks);
		request.getRequestDispatcher("/WEB-INF/jsp/genreResult.jsp").forward(request, response);

	}

}
