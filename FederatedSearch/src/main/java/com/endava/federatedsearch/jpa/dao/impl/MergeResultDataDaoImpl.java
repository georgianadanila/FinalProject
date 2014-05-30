package com.endava.federatedsearch.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.endava.federatedsearch.jpa.dao.MergeResultDataDao;
import com.endava.federatedsearch.models.MergeResultData;

@Repository
public class MergeResultDataDaoImpl implements MergeResultDataDao {

	@PersistenceContext
	private EntityManager entityManager;
	private String MergeResultQueryBySearchTerm = "Select res from MergeResultData res where res.search_term = :search_term";

	@Override
	public void save(MergeResultData toBeSaved) {
		entityManager.persist(toBeSaved);
		entityManager.flush();
	}

	@Override
	public void remove(MergeResultData toBeRemoved) {
		entityManager.remove(toBeRemoved);
		
	}

	@Override
	public MergeResultData update(MergeResultData toBeUpdated) {
		return entityManager.merge(toBeUpdated);
	}
	
	@Override
	public MergeResultData find(String imdb_id) {
		return entityManager.find(MergeResultData.class, imdb_id);
	}

	@Override
	public List<MergeResultData> findBySearchTerm(String search_term) {
//		Query query = entityManager.createNamedQuery("MergeResultData.findBySearchTerm");
//		query.setParameter("searchTerm",searchTerm);
//		return query.getResultList();
		return entityManager.createQuery(MergeResultQueryBySearchTerm, MergeResultData.class).setParameter("search_term", search_term).getResultList();
	}

}
