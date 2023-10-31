<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
<!-- ↓ｃタグが使えるようになるおまじない -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>絞り込み検索</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/hamburger.css">
<link rel="stylesheet" type="text/css" href="css/jenre.css">
</head>

<body>
	<header class="header">
		<div id="nav-drawer">
			<input id="nav-input" type="checkbox" class="nav-unshown"> 
				<label id="nav-open" for="nav-input">
					<span></span>
				</label>
				<label class="nav-unshown" id="nav-close" for="nav-input">
				</label>
			<div id="nav-content">
				<div class="menu-content">
					<ul>
						<li>
							<a href="BackToMainPageServ">
								TOPへ戻る
							</a>
						</li>
						<li>
							<a href="LogoutServ">
								ログアウト
							</a>
						</li>
						<li>
							<a href="WithdrawalJumpServ">
								退会はこちら
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<main class="wrapper">
		<h2 class="title">
			この項目から絞り込み検索！
		</h2>

	<!-- 繰り返し文 ver=変数名を指定 item= -->
		<form class="listArea" action="GenreServlet" method="get">
		<button id="roulette" class="rouletteImg" onclick="func1()" name="select" value="random"></button>
			<c:forEach var="subs" items="${subs}" varStatus="loop">
				<div class="col">
					<input type="radio" name="select" value="${subs.id}">
						${subs.name}
				</div>
				<c:if test="${loop.index % 2 == 1 || loop.last}">
		            <div style="width: 100%;"></div> <!-- 2つごとに改行 -->
		        </c:if>
		        
			</c:forEach>
			<button class="submitbtn">
				これにする！
			</button>
		</form>
	</main>
</body>
</html>