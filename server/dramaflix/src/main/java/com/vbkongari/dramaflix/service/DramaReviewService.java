package com.vbkongari.dramaflix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vbkongari.dramaflix.entity.DramaReview;

@Service
public interface DramaReviewService {
	
	public List<DramaReview> findAllComments();
	
	public List<Object> findDramaComments(String dramaId);
	
	public DramaReview writeComment(DramaReview comment);
	
	public double avgRating(String id);
	
	public DramaReview findComment(String id);
	
	public DramaReview editComment(String id, DramaReview comment);
	
	public void deleteComment(String id);

}
