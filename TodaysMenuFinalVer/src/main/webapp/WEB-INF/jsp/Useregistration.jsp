<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザー登録</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/hamburger.css">
	<link rel="stylesheet" href="css/useregistration.css">
	<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header class="header"></header>
    <div class="wrapper">
	    <h2 class="title">
	    	ユーザー登録
	    </h2>
	    <form action="Useregistration" method="post">
	    	<input name="name" class="nameInput" type="text" placeholder="ニックネーム">
            <input name="password" class="passwordInput" type="password" placeholder="パスワード">  
		    <!-- ユーザー登録されている情報を入力したときに出るエラーメッセージエリア -->
			<div class="errormsg">${registerErrorMsg}</div>
			
			<button class="loginButton">
			    <p class="loginButtonWord">
			        登録する
			    </p>
			</button>
		</form>
		
		
		<form action="TodaysMenuStartServ" method="get">
			<button class="loginButton">
			    <p class="loginButtonWord">
			        ログイン画面に戻る
			    </p>
			</button>
		</form>
	</div>
	
</body>
</html>