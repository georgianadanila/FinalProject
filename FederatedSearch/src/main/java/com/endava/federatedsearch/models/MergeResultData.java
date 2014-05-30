package com.endava.federatedsearch.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//@NamedQuery(name="MergeResultData.findBySearchTerm",query="Select res from merge_results res where res.searchTerm = :search_term")
@Entity
@Table(name="merge_results")
public class MergeResultData {

	@Id
	private int result_id;
	private String imdb_id;
	private String search_term;
	private String title;
	private String poster;
	private String genre;
	private String overview;
	private String awards;
	private String imdb_rating;
	private String actors;
	private String years;
	private String country;
	private String url;
	private Timestamp time_added;
	
	
	
	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

	public String getSearch_term() {
		return search_term;
	}

	public void setSearch_term(String search_term) {
		this.search_term = search_term;
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
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getImdb_rating() {
		return imdb_rating;
	}

	public void setImdb_rating(String imdb_rating) {
		this.imdb_rating = imdb_rating;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
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
	public boolean equals(Object obj) {
		MergeResultData result = (MergeResultData)obj;
		return (result.getImdb_id().equals(this.imdb_id));
	}
	
	@Override
	public int hashCode() {
		return imdb_id.hashCode();
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public Timestamp getTime_added() {
		return time_added;
	}

	public void setTime_added(Timestamp time_added) {
		this.time_added = time_added;
	}
	
	
	
	
}
