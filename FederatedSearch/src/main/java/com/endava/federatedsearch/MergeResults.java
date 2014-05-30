package com.endava.federatedsearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.endava.federatedsearch.models.Content;
import com.endava.federatedsearch.models.MergeResultData;
import com.endava.federatedsearch.models.PoolingServerData;

@Component
public class MergeResults {
		
	public void buildResult(Content content, PoolingServerData poolingServerData, MergeResultData mergeResult) {
		
		mergeResult.setActors(poolingServerData.getActors());
		mergeResult.setAwards(poolingServerData.getAwards());
		mergeResult.setCountry(content.getCountry());
		mergeResult.setGenre(poolingServerData.getGenre());
		mergeResult.setImdb_id(content.getImdb_id());
		mergeResult.setImdb_rating(poolingServerData.getImdbRating());
		mergeResult.setOverview(content.getOverview());
		mergeResult.setPoster(content.getPoster());
		mergeResult.setTitle(content.getTitle());
		mergeResult.setUrl(content.getUrl());
		mergeResult.setYears(String.valueOf(content.getYear()));
	}
	
	public List<MergeResultData> removeDuplicates(List<MergeResultData> resultDataList) {
		Iterator<MergeResultData> mergeIt = resultDataList.iterator();
		List<MergeResultData> noDuplicatesResult = new ArrayList<MergeResultData>();
		
		while (mergeIt.hasNext()){
            MergeResultData result = mergeIt.next();
            if(!noDuplicatesResult.contains(result)) {
            	noDuplicatesResult.add(result);
            }
        }
		
		resultDataList = noDuplicatesResult;
		return resultDataList;
	}
	
	public List<MergeResultData> merge(List<Content>  syncResult, List<PoolingServerData> poolingResult) {
		Iterator<Content> syncIt = syncResult.iterator();
		Iterator<PoolingServerData> poolingIt = poolingResult.iterator();
		List<MergeResultData> resultDataList = new ArrayList<MergeResultData>();
		PoolingServerData poolingServerData;
		Content content;
		
		while (syncIt.hasNext()) {
			content = syncIt.next();
			while (poolingIt.hasNext()) {
			poolingServerData = poolingIt.next();
			if (content.getImdb_id().equals(poolingServerData.getImdbID())) {
				MergeResultData mergeResult = new MergeResultData();
				buildResult(content, poolingServerData, mergeResult);
				resultDataList.add(mergeResult);
				}
			}
			poolingIt = poolingResult.iterator();		
		}
		resultDataList = removeDuplicates(resultDataList);
	
		return resultDataList;
	}
}
