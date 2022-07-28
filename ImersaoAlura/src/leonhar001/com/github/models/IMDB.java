package leonhar001.com.github.models;

public class IMDB {
	
	private String id = "";
	private Integer rank = 0;
	private String title = "";
	private String fullTitle = "";
	private Integer year = 0;
	private String image = "";
	private String crew = "";
	private Double imDbRating = 0.0;
	private Integer imDbRatingCount = 0;
	
	public IMDB() {
	}

	public String getId() {
		return id;
	}

	public Integer getRank() {
		return rank;
	}

	public String getTitle() {
		return title;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public Integer getYear() {
		return year;
	}

	public String getImage() {
		return image;
	}

	public String getCrew() {
		return crew;
	}

	public Double getImDbRating() {
		return imDbRating;
	}

	public Integer getImDbRatingCount() {
		return imDbRatingCount;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setImage(String image) {
		this.image = image.replaceAll("._.+_", "");
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public void setImDbRating(Double imDbRating) {
		this.imDbRating = imDbRating;
	}

	public void setImDbRatingCount(Integer imDbRatingCount) {
		this.imDbRatingCount = imDbRatingCount;
	}

	@Override
	public String toString() {
		return "Sticker [id=" + id + ", rank=" + rank + ", title=" + title + ", fullTitle=" + fullTitle + ", year="
				+ year + ", image=" + image + ", crew=" + crew + ", imDbRating=" + imDbRating + ", imDbRatingCount="
				+ imDbRatingCount + "]";
	}
	
}
