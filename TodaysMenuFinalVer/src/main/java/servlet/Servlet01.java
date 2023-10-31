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

import bean.CookBean;
import bean.LikeBean;
import bean.SubTableBean;
import bean.UserBean;
import dao.LikeDao;
import dao.categoryDao;
import dao.cookDao;
import dao.genreDao;
import service.LikeAddCook;
import service.LikeResult;
import service.RandomOne;

@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// レスポンスに文字コードを指定
		response.setContentType("text/html;charset=UTF-8");

		// メインページ(Start.jsp)で選択されたname属性、selectの値を取得
		String selected = request.getParameter("select");
		System.out.println(selected);// 確認用
		// セッションを取得
		HttpSession session = request.getSession();
		// セッションに値をセット
		session.setAttribute("selected", selected);

		// セッションに格納されたユーザーインスタンスを取得
		UserBean user = (UserBean) session.getAttribute("user");
		System.out.println(user); // 確認用

		// switch文で使うリストを先に定義
		List<CookBean> cookList = null;
		List<LikeBean> likeBeans = null;
		List<SubTableBean> subs = null;

		// フォワードするURLを格納
		String url = null;

		// selectedの値によって遷移したい先の画面が決まるので、URLを打ち分けるためにケース分けをする
		switch (selected) {
		case "random":
			// 絞り込み結果のレシピデータを格納する変数を定義
			CookBean cook = null;
			try {
				// DBの中のレシピデータを全件取得
				cookList = cookDao.selectAll();
				// ユーザーが空じゃない時はレシピデータにお気に入り情報を付与
				if (user != null) {
					try {
						// お気に入りテーブルからユーザーIDを使用して情報を取得
						likeBeans = LikeDao.selectAll(Integer.parseInt(user.getUserId()));
						cookList = LikeAddCook.likeAddCook(likeBeans, cookList);
					} catch (NumberFormatException | SQLException e) {
						request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
					}
				}
				// ランダムに1つのレシピデータを取りたいので、RandomOneクラスを使用し、変数cookにレシピデータを1つだけ格納
				cook = RandomOne.randomOne(cookList);
			} catch (ClassNotFoundException e) {
				request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
			}

			// セッションに、繰り返し表示できるようにリストと、1回目の結果用のレシピデータをセット
			session.setAttribute("cooks", cookList);
			session.setAttribute("cook", cook);

			// URLを書き換え
			url = "/WEB-INF/jsp/result.jsp";
			// caseを抜ける
			break;

		case "genre":

			// セレクトオールを実行して変数名subsのリストに代入
			subs = genreDao.selectAll();

			// sessionスコープに接続
			// HttpSession session = request.getSession();
			// スコープに変数subsを入れる
			session.setAttribute("subs", subs);
			url = "/WEB-INF/jsp/genre.jsp";

			break;

		case "category":
			subs = categoryDao.selectAll();

			session.setAttribute("subs", subs);

			url = "/WEB-INF/jsp/genre.jsp";
			break;

		case "like":

			if (user == null) {
				url = "/WEB-INF/jsp/LikeAttention.jsp"; // 本来のエラーページではなく、ここは「お気に入りはユーザー登録後に使えます」みたいな文言のほうがいいかもしれん
			} else {

				try {
					likeBeans = LikeDao.selectAll(Integer.parseInt(user.getUserId()));
				} catch (ClassNotFoundException | SQLException e) {
					request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
				}
				try {
					cookList = cookDao.selectAll();
				} catch (ClassNotFoundException e) {
					request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
				}
				System.out.println(likeBeans);
				System.out.println(cookList);
				cookList = LikeResult.likeResult(likeBeans, cookList);
				session.setAttribute("cooks", cookList); // 変数cookはgenreResultページを利用するために仮設定してある物なので、後で整合性をとります

				url = "WEB-INF/jsp/genreResult.jsp";
			}
			break;
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
