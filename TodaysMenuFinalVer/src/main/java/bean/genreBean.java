package bean;

import java.io.Serializable;

public class genreBean implements Serializable {

	private String genreId;
	private String genreValue;
	private String genreName;

	public String getGenreId() {
		return genreId;
	}

	public String getGenreValue() {
		return genreValue;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	public void setGenreValue(String genreValue) {
		this.genreValue = genreValue;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

}
