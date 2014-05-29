package com.endava.federatedsearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PoolingServerData {
	@JsonProperty("Genre")
	private String Genre;
	@JsonProperty("Awards")
	private String Awards;
	@JsonProperty("imdbRating")
	private String imdbRating;
	@JsonProperty("Actors")
	private String Actors;
	@JsonProperty("imdbID")
	private String imdbID;
	
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
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
	
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	@Override
	public String toString() {
		return "PoolingServerData [imdbID=" + imdbID + ", Genre=" + Genre + ", Awards=" + Awards
				+ ", imdbRating=" + imdbRating + ", Actors=" + Actors +"]";
	}
	
	
	
	
}
