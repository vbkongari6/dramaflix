package com.vbkongari.dramaflix.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbkongari.dramaflix.entity.DramaReview;
import com.vbkongari.dramaflix.exception.CommentNotFoundException;
import com.vbkongari.dramaflix.exception.DramaNotFoundException;
import com.vbkongari.dramaflix.repository.DramaReviewRepository;

@Service
public class DramaReviewServiceImplementation implements DramaReviewService{
	
	@Autowired
	DramaReviewRepository repository;

	DramaService dService;
	UserService uService;
	
	@Override
	public List<DramaReview> findAllComments() {
		return repository.findAllComments();
	}

	@Override
	@Transactional
	public DramaReview writeComment(DramaReview comment) {
		comment.setTimestamp(new Date());
		return repository.writeComment(comment);
	}

	@Override
	public double avgRating(String id) {
		return repository.avgRating(id);
	}

	@Override
	public DramaReview findComment(String id) {
		return repository.findComment(id);
	}

	@Override
	public DramaReview editComment(String id, DramaReview comment) {
		DramaReview existing = repository.findComment(id);
		if(existing == null) {
			throw new CommentNotFoundException("Comment with id: " + id + " not found");
		}
		return repository.editComment(comment);
	}

	@Override
	public void deleteComment(String id) {
		DramaReview existing = repository.findComment(id);
		if(existing == null) {
			throw new DramaNotFoundException("Drama with id: " + id + " not found");
		}
		repository.deleteComment(id, existing);
	}	
}