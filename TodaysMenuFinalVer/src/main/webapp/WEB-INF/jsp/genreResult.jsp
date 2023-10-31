<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<!-- ↓ｃタグが使えるようになるおまじない -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日の晩御飯はこちら</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/hamburger.css">
<link rel="stylesheet" type="text/css" href="css/genreResult.css">
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
						<li><a href="BackToMainPageServ"> TOPへ戻る </a></li>
						<li><a href="LogoutServ"> ログアウト </a></li>
						<li><a href="WithdrawalJumpServ"> 退会はこちら </a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<!-- GenreSerletから飛んできた値がリストに入力される -->
	<main class="wrapper">
		<h2 class="title">今日の晩御飯候補</h2>
		<div class="scrollArea">
			<c:forEach var="ck" items="${cooks}" varStatus="loop">
				<div class="list">
					<a class="cookUrl" href="${ck.url}"> ${ck.cookName} </a>
					<!-- お気に入りボタンの要素ボックス -->
					<div class="favoriteArea">
						<button id="favoriteButton${loop.index}"
								 class="unfavorited" 
								 onclick="toggleFavorite(this)"
								 data-favorited="${ck.likes}"
								 data-object-id="${ck.cookId}">
							<div id="heartImage${loop.index}"
								 class="favorited">
							</div>
						</button>
					</div>
				</div>
			</c:forEach>
		</div>
		<form action="ListToRandomOneServ" method="get">
			<button class="buttonStyle">リストの中からランダムで選ぶ</button>
		</form>
		
		<a class="pageUrl" href="BackToMainPageServ"> トップ画面に戻る </a>
		<!-- <button class="buttonStyle">
			
		</button> -->
	</main>
	<script src="js/genreResult.js">
	</script>
</body>
</html>