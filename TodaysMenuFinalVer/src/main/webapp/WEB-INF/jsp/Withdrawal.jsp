<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>退会フォーム</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/hamburger.css">
<link rel="stylesheet" href="css/withdrawal.css">
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
        <img src="img/bikkuri.png" alt="">
        <h2 class="withdrawalTitle">
            退会しますか？
        </h2>

        <p class="withdrawalDescription">
            下記のボタンを押すと退会処理が実行されます。<br>
            お客様の情報は<br>
            全て削除されますが、よろしいですか？
        </p>

        <form action="WithdrawalServ" method="post">
            <button type="submit">
            	はい、退会します
            </button>
        </form>
        <a class="noSubmit" href="BackToMainPageServ">
        	いいえ、退会しません
        </a>
    </main>
</body>
</html>