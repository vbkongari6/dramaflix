package com.vbkongari.dramaflix.repository;

import java.util.List;

import com.vbkongari.dramaflix.entity.DramaReview;

public interface DramaReviewRepository {
	
	public List<DramaReview> findAllComments();
	
	public DramaReview writeComment(DramaReview comment);

}
