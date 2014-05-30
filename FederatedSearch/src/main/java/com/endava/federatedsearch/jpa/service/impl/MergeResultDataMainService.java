package com.endava.federatedsearch.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endava.federatedsearch.jpa.service.MergeResultDataService;
import com.endava.federatedsearch.models.MergeResultData;

@Service
public class MergeResultDataMainService {

	@Autowired
	private MergeResultDataService mergeResultService;
	
	public MergeResultData findResult(String imdb_id) {
		return mergeResultService.find(imdb_id);
	}
	
	public void insertMergeResultData(MergeResultData mergeData) {
		mergeResultService.save(mergeData);
	}

 
	public List<MergeResultData> findMergeResultBySearchTerm(String searchTerm) {
		List<MergeResultData> mergeResults = mergeResultService.findBySearchTerm(searchTerm);
//		for(MergeResultData mergeResult : mergeResults) {
//			System.out.println(mergeResult);
//		}
		return mergeResults;
	}
	/**
	 * Delete an existing merge_result from the database
	 */
	public void deleteMergeResultData(String imdb_id) {
		MergeResultData mergeData = mergeResultService.find(imdb_id);
		if (mergeData != null) {
			mergeResultService.remove(mergeData);
		}
	}
}
