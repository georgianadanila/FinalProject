package com.endava.federatedsearch.jpa.dao;

import java.util.List;

import com.endava.federatedsearch.models.MergeResultData;

public interface MergeResultDataDao {

	public void save(MergeResultData toBeSaved);
	
	public void remove(MergeResultData toBeRemoved);
	
	public MergeResultData update(MergeResultData toBeUpdated);
	
	public MergeResultData find(String imdb_id);
	
	public List<MergeResultData> findBySearchTerm(String search_term);
}
