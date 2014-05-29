package com.endava.federatedsearch.models;


public class MergeResultData {

	private String imdb_id;
	private String title;
	private String poster;
	private String Genre;
	private String overview;
	private String Awards;
	private String imdbRating;
	private String Actors;
	private int year;
	private String country;
	private String url;
	
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		Awards = awards;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "MergeResultData [imdb_id=" + imdb_id + ", title=" + title
				+ ", Genre=" + Genre + ", overview=" + overview + ", Awards="
				+ Awards + ", imdbRating=" + imdbRating + ", Actors=" + Actors
				+ ", year=" + year + ", country=" + country + ", url=" + url
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		MergeResultData result = (MergeResultData)obj;
		return (result.getImdb_id().equals(this.imdb_id));
	}
	
	@Override
	public int hashCode() {
		return imdb_id.hashCode();
	}
	
	
	
}
