package com.vbkongari.dramaflix.repository;

import java.util.List;

import com.vbkongari.dramaflix.entity.DramaReview;

public interface DramaReviewRepository {
	
	public List<DramaReview> findAllComments();
	
	public List<Object> findDramaComments(String dramaId);
	
	public DramaReview writeComment(DramaReview comment);
	
	public double avgRating(String id);

	public DramaReview findComment(String id);
	
	public DramaReview editComment(DramaReview comment);
	
	public void deleteComment(String id, DramaReview comment);	
}
