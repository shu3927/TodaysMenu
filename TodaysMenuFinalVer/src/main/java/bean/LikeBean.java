package bean;

import java.io.Serializable;

public class LikeBean implements Serializable {

	private String userId;
	private String cookId;
	private String like;

	public LikeBean(String userId, String cookId, String like) {
		super();
		this.userId = userId;
		this.cookId = cookId;
		this.like = like;
	}

	public LikeBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getUserId() {
		return userId;
	}

	public String getCookId() {
		return cookId;
	}

	public String getLike() {
		return like;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCookId(String cookId) {
		this.cookId = cookId;
	}

	public void setLike(String like) {
		this.like = like;
	}

}
