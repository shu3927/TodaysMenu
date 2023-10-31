package bean;

import java.io.Serializable;

public class categoryBean implements Serializable {

	private String categoryId;
	private String categoryValue;
	private String categoryName;

	public categoryBean(String categoryId, String categoryValue, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryValue = categoryValue;
		this.categoryName = categoryName;
	}

	public categoryBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getCategoryValue() {
		return categoryValue;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
