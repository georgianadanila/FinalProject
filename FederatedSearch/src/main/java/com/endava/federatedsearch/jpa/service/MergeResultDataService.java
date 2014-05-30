package com.endava.federatedsearch.jpa.service;

import java.util.List;

import com.endava.federatedsearch.models.MergeResultData;

public interface MergeResultDataService {

	public void save(MergeResultData toBeSaved);
	
	public void remove(MergeResultData toBeRemoved);
	
	public MergeResultData update(MergeResultData toBeUpdated);
	
	public MergeResultData find(String imdb_id);
	
	public List<MergeResultData> findBySearchTerm(String searchTerm);
}
