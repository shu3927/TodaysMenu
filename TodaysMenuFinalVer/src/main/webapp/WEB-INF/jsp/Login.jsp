<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ログインフォーム</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<main>
		<!-- オープニング画面のエリア 
		<div class="loader">
			<img class="openAreaImg" src="img/roulette.png" alt="ルーレット">
			<h2 class="loadingTitle">
				Now Loading...
			</h2>
		</div>-->
		<!-- 通常のログイン画面 -->
		<div class="content">
			<!-- ルーレット画像 -->
			<img class="roulette" src="img/roulette.png" alt="ルーレット">

			<form action="LoginCheck" method="post">
				<div class="nameAreabg">
					<input name="name" class="nameInput" type="text"
						placeholder="ニックネーム">
				</div>
				<input name="password" class="passwordInput" type="password"
					placeholder="パスワード">

				<!-- jsを使用しLoginCheck.javaにnameとpassの値を渡す -->
				<button id="send" class="loginButton">
					<p class="loginButtonWord">ログイン</p>
				</button>
			</form>

			<!-- ログインボタンのあとに値の結果を返す -->
			<div class="errorLog">${loginErrorMsg}</div>

			<p class="loginformGest">
				<a class="loginformGestLink" href="GuestLoginServ"> ゲストでログイン </a>
			</p>
			<p class="loginformUser">
				<a class="loginformUserLink" href="ForwardRegisterServ">
					ユーザー登録はこちら </a>
			</p>
		</div>
	</main>
	
	<script>
	    window.onload = function () {
	        const loader = document.querySelector(".loader");
	        const content = document.querySelector(".content");
	
	        setTimeout(() => {
	            loader.classList.add("loaded");
	            content.style.visibility = "visible"; // コンテンツを表示
	        }, 2000);
	    };
	</script>
</body>
</html>