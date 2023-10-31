package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CookBean;
import service.RandomOne;

/**
 * Servlet implementation class ListToRandomOneServ
 * このサーブレットは、前画面で表示されたリストの中からランダムに1つのレシピを決定し、そのデータをjspに送るサーブレットです
 */
@WebServlet("/ListToRandomOneServ")
public class ListToRandomOneServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListToRandomOneServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションの取得
		HttpSession session = request.getSession();

		// sessionに格納されているrecipesを受け取る(要明示キャスト)
		List<CookBean> recipes = (List<CookBean>) session.getAttribute("cooks");

		CookBean oneRecipe = null;
		// RandomOneクラスを作成し、staticメソッドのrandomOne(List<cookBean> recipes)にrecipesを渡す
		// 戻り値として1つに絞り込まれたcookBeanを受け取る
		oneRecipe = RandomOne.randomOne(recipes);

		// 1つに絞り込まれたレシピデータをセッションにセット
		session.setAttribute("cook", oneRecipe);

		// レシピデータ表示用のjspに遷移
		request.getRequestDispatcher("WEB-INF/jsp/result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
