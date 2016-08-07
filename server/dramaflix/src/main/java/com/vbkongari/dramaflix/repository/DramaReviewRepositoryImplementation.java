package com.vbkongari.dramaflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

	

}
