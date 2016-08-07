package com.vbkongari.dramaflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.vbkongari.dramaflix.entity.Drama;

@Repository
public class DramaRepositoryImplementation implements DramaRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Drama> findAllDramas() {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.findAllDramas", Drama.class);
		return query.getResultList();
	}
	
	@Override
	public List<Drama> findTopRatedIMDBMovies() {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.findTopRatedDrama", Drama.class);
		query.setParameter("pType", "movie");
		return query.getResultList();
	}
	
	@Override
	public List<Drama> findTopRatedIMDBTVSeries() {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.findTopRatedDrama", Drama.class);
		query.setParameter("pType", "series");
		return query.getResultList();
	}	
	
	@Override
	public List<Drama> findDramaByType(String type) {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.findDramaByType", Drama.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public List<Drama> findDramaByYear(int year) {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.findDramaByYear", Drama.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	@Override
	public List<Drama> findDramaByGenre(String genre) {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.findDramaByGenre", Drama.class);
		query.setParameter("pGenre", genre);
		return query.getResultList();
	}

	@Override
	public Drama findOneDrama(String id) {
		return em.find(Drama.class, id);
	}

	@Override
	public Drama findDramaByTitle(String title) {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.findDramaByTitle", Drama.class);
		query.setParameter("pTitle", title);
		List<Drama> dramas = query.getResultList();
		if(dramas != null && dramas.size() == 1) {
			return dramas.get(0);
		}
		return null;
	}

	@Override
	public Drama addDrama(Drama drama) {
		em.persist(drama);
		return drama;
	}

	@Override
	public Drama updateDrama(Drama drama) {
		return em.merge(drama);
	}

	@Override
	public void deleteDrama(Drama drama) {		
		em.remove(drama);
	}

	

	
}
