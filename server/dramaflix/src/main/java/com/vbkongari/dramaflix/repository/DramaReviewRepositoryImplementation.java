package com.vbkongari.dramaflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vbkongari.dramaflix.entity.DramaReview;

@Repository
public class DramaReviewRepositoryImplementation implements DramaReviewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<DramaReview> findAllComments() {
		TypedQuery<DramaReview> query = em.createNamedQuery("DramaReview.findAllComments", DramaReview.class);
		return query.getResultList();
	}
	
	@Override
	public List<Object> findDramaComments(String dramaId) {
		Query query = em.createNamedQuery("DramaReview.findDramaComments");
		query.setParameter("pDramaId", dramaId);	
		@SuppressWarnings("unchecked")
		List<Object> list = query.getResultList();
		return list;
	}
		
	@Override
	@Transactional
	public DramaReview writeComment(DramaReview comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public double avgRating(String id) {
		Query query = em.createNamedQuery("DramaReview.avgRating");
		query.setParameter("pDramaId", id);		
		Object result = query.getSingleResult();   
		if (result != null) { return (double) result; }		
		return 0;
	}

	@Override
	public DramaReview findComment(String id) {
		return em.find(DramaReview.class, id);
	}

	@Override
	@Transactional
	public DramaReview editComment(DramaReview comment) {
		return em.merge(comment);
	}

	@Override
	@Transactional
	public void deleteComment(String id, DramaReview comment) {
		em.remove(comment);
	}

	
	
}
