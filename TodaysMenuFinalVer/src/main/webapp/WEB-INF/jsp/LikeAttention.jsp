<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ユーザー未登録時の注意ページ</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/LikeAttention.css">
</head>
<body>
	<main class="wrapper">
		<div class="descriptionArea">
			<h2 class="title">
				こちらの機能はユーザー限定機能です。
			</h2><br>
			<div class="des">
				お気に入り登録機能はログイン後、使用可能になります。
			</div><br>
			<div class="des">
				ユーザー未登録の場合は<a href="ForwardRegisterServ">登録ページへ。</a>
			</div><br>
			<div class="des">
				登録済みの方はログインページへお進みください。
			</div><br>
			<form action="TodaysMenuStartServ" method="get">
				<button>ログイン画面へ進む</button>
			</form>
		</div>
	</main>
</body>
</html>