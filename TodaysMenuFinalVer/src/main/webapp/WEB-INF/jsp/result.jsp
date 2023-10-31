<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>結果画面</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/hamburger.css">
<link rel="stylesheet" href="css/result.css">
</head>
<body>
	<header class="header">
		<div id="nav-drawer">
			<input id="nav-input" type="checkbox" class="nav-unshown">
			<label id="nav-open" for="nav-input">
				<span>
				</span>
			</label>
			<label class="nav-unshown" id="nav-close" for="nav-input">
			</label>
			<div id="nav-content">
				<div class="menu-content">
					<ul>
						<li><a href="BackToMainPageServ"> TOPへ戻る </a></li>
						<li><a href="LogoutServ"> ログアウト </a></li>
						<li><a href="WithdrawalJumpServ"> 退会はこちら </a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<main class="wrapper">
		<h2 class="title">
			今日の晩御飯はこちら!!
		</h2>
		<div class="favoriteArea">
			 <c:set var="cook" value="${cook}" />
			<a class="cookUrl" href="${cook.url}">${cook.cookName}</a>
			<button id="favoriteButton" 
					 onclick="toggleFavorite(this)"
					 data-favorited="${cook.likes}"
					 class="unfavorited"
					 data-object-id="${cook.cookId}">
				<div class="favorited">
					<!-- 赤いハートをcssで出します -->
				</div>
			</button>
			<div class="notes">
				↑クリックでリンクアクセス
			</div>
		</div>
		
		<form class="formArea" action="ListToRandomOneServ" method="get">
			<div class="buttonStyle">
				<button class="buttonSize">
					ルーレットを再度回す
				</button>
			</div>
		</form>
		<div class="buttonStyle2">
			<a class="pageUrl" href ="BackToMainPageServ">
				トップ画面に戻る
			</a>
		</div>
	</main>
	<!--<script src="js/favorite.js"></script>-->
	<script src="js/genreResult.js">
	</script>
</body>
</html>