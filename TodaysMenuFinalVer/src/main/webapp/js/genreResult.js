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
 

// お気に入りを追加するサーブレットのURL
const favoriteServletURL = "InsertLikeServ";
// お気に入りを解除するサーブレットのURL
const unfavoriteServletURL = "DeleteLikeServ";

function toggleFavorite(button) {
	// data-favoritedが0か1かを判別
	let dataFavorited = button.getAttribute("data-favorited");
	let cookId = button.getAttribute("data-object-id");

console.log('ここにきてるかな？');
	if (dataFavorited === "0") {

		// ハートの画像を切り替える
		/*
		"favoriteButton"要素が "unfavorited" クラスを持っている場合、
		つまりその要素がまだ「お気に入りされていない」状態である場合に
		条件は true */
		if (button.classList.contains("unfavorited")) {

			// お気に入りを追加する場合
			button.classList.remove("unfavorited");
			button.classList.add("favorited");

			// お気に入り追加後の画像に切り替え
			// heartImages[index].src = "img/favoriteOn.png";

			// data-favoritedの値を上書きする（0から1に変更）
			button.setAttribute("data-favorited", "1");

			// お気に入りを追加するサーブレットを呼び出す
			fetch(favoriteServletURL, {
				method: "POST",
				body: `cookId=${cookId}`, // 1はお気に入り追加の状態
				headers: {
					"Content-Type": "application/x-www-form-urlencoded",
				},
			})
				.then(response => {
					if (response.status !== 200) {
						//window.location(response);
						window.location.href = "InsertLikeServ";
					}
				})
				.catch(error => {
					console.error("ネットワークエラー: " + error);
				});
		}
	} else {
		// お気に入りを解除する場合
		button.classList.remove("favorited");
		button.classList.add("unfavorited");
		// お気に入り解除後の画像に切り替え
		//heartImages.src = "img/favorite.png";

		// data-favoritedの値を上書きする（1から0に変更）
		button.setAttribute("data-favorited", "0");

		// お気に入りを解除するサーブレットを呼び出す
		fetch(unfavoriteServletURL, {
			method: "POST",
			body: `cookId=${cookId}`, // 0はお気に入り解除の状態
			headers: {
				"Content-Type": "application/x-www-form-urlencoded",
			},
		})
			.then(response => {
				if (response.status !== 200) {
					window.location.href = "InsertLikeServ";
				}
			})
			.catch(error => {
				console.error("ネットワークエラー: " + error);
			});
	}
};