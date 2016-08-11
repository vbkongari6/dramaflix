package com.vbkongari.dramaflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

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
	public DramaReview writeComment(DramaReview comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public double avgRating(String id) {
//		Query query = em.createNamedQuery("DramaReview.avgRating", DramaReview.class);
//		query.setParameter("pDramaId", id);
//		double v = (double) query.getResultList().get(0);
//		System.out.println(v);
//		System.out.println(v);
//		System.out.println(v);
//		System.out.println(v);
//		System.out.println(v);
//		return v;	

//		TypedQuery<Object> query = em.createNamedQuery("DramaReview.avgRating", DramaReview.class);
//		return query.getSingleResult();
		//
		return 0;
	}

	@Override
	public DramaReview findComment(String id) {
		return em.find(DramaReview.class, id);
	}

	@Override
	public DramaReview editComment(DramaReview comment) {
		return em.merge(comment);
	}

	@Override
	public void deleteComment(String id, DramaReview comment) {
		em.remove(comment);
	}
	
	
}
