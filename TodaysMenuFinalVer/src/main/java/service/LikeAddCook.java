package service;

import java.util.List;

import bean.CookBean;
import bean.LikeBean;

public class LikeAddCook {

	// 多分ユーザーIDが○○の時にLikeがついてるレシピIDはLikeテーブル(名称未定)からListとして取れているはずで、そのListがlikes
	// 上記リストと、単純に全てのレシピデータを格納しているbeanリストをサーブレットから受け取る
	// その2つをcookIdで比較して、同じものが見つかったその時のbeanの中身のlikesフィールドに1を格納する
	public static List<CookBean> likeAddCook(List<LikeBean> likes, List<CookBean> bean) {
		// 外ループでお気に入りオブジェクトのリストを展開
		for (int i = 0; i < likes.size(); i++) {
			// 内ループでレシピオブジェクトのリストを展開
			for (int j = 0; j < bean.size(); j++) {
				// likesのcookIdとbeanのcookIdを比較し、一致したものがあるかを調べている
				if (likes.get(i).getCookId().equals(bean.get(j).getCookId())) {
					// 一致した時のレシピデータのlikesを1に変更
					bean.get(j).setLikes(1);
					// 一致したものが格納された場合、それ以上見る必要がないので内ループをbreakする
					break;
				}
			}
		}
		return bean;
	}

}
