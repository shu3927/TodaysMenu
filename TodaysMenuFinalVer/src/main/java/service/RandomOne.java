package service;

import java.util.List;
import java.util.Random;

import bean.CookBean;

/**
 * 
 * @author 0801JA
 *         このクラスは、レシピデータの入ったリストを引数として受け取り、ランダムに1つのレシピを絞り込み、サーブレットに返すためのクラスです
 */
public class RandomOne {

	// このメソッドは、レシピデータの入ったリストを引数として受け取り、ランダムに1つのレシピを絞り込み、サーブレットに返すためのメソッドです
	public static CookBean randomOne(List<CookBean> cookBeans) {

		// new Randomでjavaのランダムクラスのオブジェクトを生成
		// nextIntでリストのサイズまでの範囲内で値を返す(0~indexまで、index+1を含まない)
		CookBean bean = cookBeans.get(new Random().nextInt(cookBeans.size()));
		return bean;
	}
}
