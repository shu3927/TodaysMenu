package bean;

import java.io.Serializable;

public class SubTableBean implements Serializable {

	private String id;
	private String name;

	public SubTableBean(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public SubTableBean() {
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
