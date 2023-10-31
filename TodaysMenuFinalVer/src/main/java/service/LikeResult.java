package service;

import java.util.ArrayList;
import java.util.List;

import bean.CookBean;
import bean.LikeBean;

/**
 * 
 * @author 0801JA このクラスは、ユーザーごとのお気に入りレシピリストをサーブレットに返すクラスの仮組みです
 */
public class LikeResult {

	// 多分ユーザーIDが○○の時にLikeがついてるレシピIDはLikeテーブル(名称未定)からListとして取れているはずで、そのListがlikes
	// 上記リストと、単純に全てのレシピデータを格納しているbeanリストをサーブレットから受け取る
	// その2つをcookIdで比較して、同じものが見つかったその時のbeanの中身(レシピデータ)を結果用リストに格納する
	public static List<CookBean> likeResult(List<LikeBean> likes, List<CookBean> bean) {

		// 結果表示用のリストresultを定義
		List<CookBean> result = new ArrayList<CookBean>();
		// 外ループでお気に入りオブジェクトのリストを展開
		for (int i = 0; i < likes.size(); i++) {
			// 内ループでレシピオブジェクトのリストを展開
			for (int j = 0; j < bean.size(); j++) {
				// likesのcookIdとbeanのcookIdを比較し、一致したものがあるかを調べている
				if (likes.get(i).getCookId().equals(bean.get(j).getCookId())) {
					// 一致した時のレシピデータを結果表示用のリストに格納
					// …する前に、現在のレシピデータはlikes情報が0のままなので、一致したレシピデータはlikesを1にする必要がある
					bean.get(j).setLikes(1);
					// 上記コードでlikes情報を1に書き換えたインスタンスを格納
					result.add(bean.get(j));
					// 一致したものが格納された場合、それ以上見る必要がないので内ループをbreakする
					break;
				}
			}
		}
		return result;
	}
}
