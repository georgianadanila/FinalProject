package com.endava.federatedsearch.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown=true)
public class SynchronousServerData {
	@JsonIgnore
	private String searchTerm;
	private int noEntries;
	private List<Content> content;
	
	public int getNoEntries() {
		return noEntries;
	}
	public void setNoEntries(int noEntries) {
		this.noEntries = noEntries;
	}
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	
	public String getSearchTerm() {
		return searchTerm;
	}
	
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	@Override
	public String toString() {
		return "SynchronousServerData [searchTerm=" + searchTerm + ", noEntries="
				+ noEntries + ", content=" + content + "]";
	}
	
	 

}
