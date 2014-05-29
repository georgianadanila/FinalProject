package com.endava.federatedsearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown=true)
public class Content {

	private String title;
	private int year;
	private String url;
	private String country;
	private String overview;
	private String poster;
	private String imdb_id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	
	@Override
	public String toString() {
		return "Content [imdb_id=" + imdb_id +", title=" + title + ", year=" + year + ", url=" + url
				+ ", country=" + country + ", overview=" + overview
				+ ", poster=" + poster + "]";
	}
	
}
