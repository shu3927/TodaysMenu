/**
 * 
 */
 // ページが読み込まれた際に初期状態を確認
document.addEventListener("DOMContentLoaded", function() {
    const buttons = document.querySelectorAll(".favoriteArea button");
    buttons.forEach(button => {
        const dataFavorited = button.getAttribute("data-favorited");
        if (dataFavorited === "1") {
            button.classList.remove("unfavorited");
            button.classList.add("favorited");
        }
    });
});
 


const unfavoriteServletURL = "/unfavorite-servlet"; // お気に入りを解除するサーブレットのURL
const favoriteServletURL = "/favorite-servlet"; // お気に入りを追加するサーブレットのURL

// お気に入りボタンの要素を取得する
const favoriteButtons = document.querySelectorAll("[id^='favoriteButton']");
const heartImages = document.querySelectorAll("[id^='heartImage']");

favoriteButtons.forEach((button, index) => {
  button.addEventListener("click", function() {
    if (button.classList.contains("unfavorited")) {
      // お気に入りを追加する場合
      button.classList.remove("unfavorited");
      button.classList.add("favorited");
      // お気に入り追加後の画像に切り替え
      heartImages[index].src = "img/favoriteOn.png";
      // ここでサーバーサイドにデータを送信する処理を実装
    } else {
      // お気に入りを解除する場合
      button.classList.remove("favorited");
      button.classList.add("unfavorited");
      // お気に入り解除後の画像に切り替え
      heartImages[index].src = "img/favorite.png";
      // ここでサーバーサイドにデータを送信する処理を実装
    }
  });
});


favoriteButton.addEventListener("click", function() {
	if (favoriteButton.classList.contains("unfavorited")) {
		// お気に入りを解除するサーブレットを呼び出す
		fetch(unfavoriteServletURL, {
			method: "POST", // サーバーサイドでのHTTPメソッドに合わせて変更
		})
			.then(response => {
				if (response.status === 200) {
					favoriteButton.classList.remove("unfavorited");
					favoriteButton.classList.add("favorited");
				} else {
					console.error("お気に入り解除に失敗しました");
				}
			})
			.catch(error => {
				console.error("ネットワークエラー: " + error);
			});
	} else {
		// お気に入りを追加するサーブレットを呼び出す
		fetch(favoriteServletURL, {
			method: "POST", // サーバーサイドでのHTTPメソッドに合わせて変更
		})
			.then(response => {
				if (response.status === 200) {
					favoriteButton.classList.remove("favorited");
					favoriteButton.classList.add("unfavorited");
				} else {
					console.error("お気に入り追加に失敗しました");
				}
			})
			.catch(error => {
				console.error("ネットワークエラー: " + error);
			});
	}
});