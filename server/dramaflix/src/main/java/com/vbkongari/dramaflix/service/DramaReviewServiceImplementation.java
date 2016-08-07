package com.vbkongari.dramaflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbkongari.dramaflix.entity.DramaReview;
import com.vbkongari.dramaflix.repository.DramaReviewRepository;

@Service
public class DramaReviewServiceImplementation implements DramaReviewService{
	
	@Autowired
	DramaReviewRepository repository;
	
	@Override
	public List<DramaReview> findAllComments() {
		return repository.findAllComments();
	}

	@Override
	@Transactional
	public DramaReview writeComment(DramaReview comment) {
		comment.getTimestamp();
		return repository.writeComment(comment);
	}

	
}