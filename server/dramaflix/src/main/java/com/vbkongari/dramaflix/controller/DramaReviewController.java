package com.vbkongari.dramaflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vbkongari.dramaflix.entity.DramaReview;
import com.vbkongari.dramaflix.service.DramaReviewService;

@RestController
@RequestMapping(path="dramareviews")
public class DramaReviewController {
	
	@Autowired
	DramaReviewService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<DramaReview> findAllComments() {
		return service.findAllComments();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="avgrating/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public double avgRating(@PathVariable("id") String dramaId) {
		return service.avgRating(dramaId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DramaReview findComment(@PathVariable("id") String commentId) {
		return service.findComment(commentId);
	}	

	// requestbody should contain userid, dramaid, review or/and rating
	@RequestMapping(method=RequestMethod.POST, path="comment", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DramaReview writeComment(@RequestBody DramaReview comment) {		
		return service.writeComment(comment);
	}
	
//	@RequestMapping(method=RequestMethod.PUT, path="{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public DramaReview editComment(@PathVariable("id") String commentId, @RequestBody DramaReview comment) {
//		return service.editComment(commentId, comment);
//	}	
//	
//	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
//	public void deleteComment(@PathVariable("id") String commentId) {
//		service.deleteComment(commentId);
//	}	
}
