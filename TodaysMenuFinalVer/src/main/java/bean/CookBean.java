package bean;

import java.io.Serializable;

public class CookBean implements Serializable {
	// cookテーブルの格納
	private String cookId;
	private String genreId;
	private String categoryId;
	private String foodId;
	private String cookName;
	private String url;
	private int likes;

	public CookBean(String cookId, String genreId, String categoryId, String foodId, String cookName, String url) {
		super();
		this.cookId = cookId;
		this.genreId = genreId;
		this.categoryId = categoryId;
		this.foodId = foodId;
		this.cookName = cookName;
		this.url = url;
	}

	public CookBean(String cookId, String cookName, String url) {
		this.cookId = cookId;
		this.cookName = cookName;
		this.url = url;
	}

	public CookBean() {
	}

	public String getCookId() {
		return cookId;
	}

	public String getGenreId() {
		return genreId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getFoodId() {
		return foodId;
	}

	public String getCookName() {
		return cookName;
	}

	public String getUrl() {
		return url;
	}

	public void setCookId(String cookId) {
		this.cookId = cookId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public void setCookName(String cookName) {
		this.cookName = cookName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}
