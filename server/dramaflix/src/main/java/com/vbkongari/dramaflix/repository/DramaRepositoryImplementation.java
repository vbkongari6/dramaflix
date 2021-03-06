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
	public List<Drama> findTopRatedDramas(String type) {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.findTopRatedDramas", Drama.class);
		if(type.equalsIgnoreCase("movies")) { query.setParameter("pType", "movie"); }
		else if(type.equalsIgnoreCase("tvseries")) { query.setParameter("pType", "series"); }		
		return query.getResultList();
	}	
	
	@Override
	public List<Drama> filterDramasByType(String type) {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.filterDramasByType", Drama.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public List<Drama> filterDramasByYear(int year) {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.filterDramasByYear", Drama.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	@Override
	public List<Drama> filterDramasByGenre(String genre) {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.filterDramasByGenre", Drama.class);
		query.setParameter("pGenre", genre);
		return query.getResultList();
	}
	
	@Override
	public List<Drama> sortDramasByYearDESC() {
		TypedQuery<Drama> query = em.createNamedQuery("Drama.sortDramasByYearDESC", Drama.class);
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
	public void deleteDrama(String id, Drama drama) {	
		em.remove(drama);
	}

	

	

	
}
