package com.vbkongari.dramaflix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vbkongari.dramaflix.entity.DramaReview;

@Service
public interface DramaReviewService {
	
	public List<DramaReview> findAllComments();
	
	public DramaReview writeComment(DramaReview comment);

}
