package com.endava.federatedsearch.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.endava.federatedsearch.jpa.dao.MergeResultDataDao;
import com.endava.federatedsearch.jpa.service.MergeResultDataService;
import com.endava.federatedsearch.models.MergeResultData;

@Service
@Transactional(readOnly = true)
public class MergeResultDataServiceImpl implements MergeResultDataService {

	@Autowired
	private MergeResultDataDao mergeResultDao;
	
	@Transactional
	public void save(MergeResultData toBeSaved) {
		mergeResultDao.save(toBeSaved);
	}

	@Transactional
	public void remove(MergeResultData toBeRemoved) {
		mergeResultDao.remove(mergeResultDao.update(toBeRemoved));
	}

	@Transactional
	public MergeResultData update(MergeResultData toBeUpdated) {
		return mergeResultDao.update(toBeUpdated);
	}

	public MergeResultData find(String imdb_id) {
		return mergeResultDao.find(imdb_id);
	}

	@Override
	public List<MergeResultData> findBySearchTerm(String search_term) {
		return mergeResultDao.findBySearchTerm(search_term);
	}

}
