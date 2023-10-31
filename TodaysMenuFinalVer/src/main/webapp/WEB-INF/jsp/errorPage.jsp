<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>エラー画面</title>
<link rel="stylesheet" href="css/reset.css">
<style>
    .main {
    height: 100vh;
        margin-top:250px;
    }

    h2 {
        line-height: 30px;
    }

    .btn {
        margin-top: 30px;
        width: 150px;
        height: 30px;
    }
</style>
</head>

<body>
    <main>
        <div class="main">
            <h2>
                予期せぬエラーが発生しました。<br>
                5秒後に自動的にページが移動します。<br>
                移動しない場合は下記のボタンをタップ
            </h2>
            <!-- エラーページに遷移5秒後Start.htmlに飛ぶ -->
            <form id="StartPage" action="BackToMainPageServ">
                <input class="btn" type="submit" value="戻る">
            </form>
        </div>
    </main>
    <script>
        //5秒後に遷移します。
        setTimeout(function () {
            document.getElementById("StartPage").submit()
        }, 5000);
    </script>
</body>
</html>