<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ルーレット回す画面</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/hamburger.css">
<link rel="stylesheet" href="css/start.css">
<script src="js/jquery-3.6.0.min.js"></script>

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
					<!-- aタグ内のhrefにサーブレットURLを入力 -->
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
	<main>
		<div class="wrapper">
			<h2 class="title">
				今日は献立は何にする？
			</h2>
			<form action="Servlet01" method="get">
				
				<div class="roulette">
					<button id="roulette" class="rouletteImg" onclick="func1()" name="select" value="random"></button>
				</div>
				<div class="roulette">
					<button class="buttonStyle" onclick="func1()" name="select" value="random">
						ルーレットを回す
					</button>
					<button class="buttonStyle" name="select" value="genre">
						ジャンルから選ぶ
					</button>
					<button class="buttonStyle" name="select" value="category">
						カテゴリから選ぶ
					</button>
					<button class="buttonStyle" name="select" value="like">
						お気に入りから選ぶ
					</button>
				</div>
			</form>
		</div>
	</main>
</body>
</html>