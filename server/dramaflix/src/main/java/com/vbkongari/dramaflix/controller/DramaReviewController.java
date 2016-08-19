package com.vbkongari.dramaflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@Autowired
	UserController uC;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<DramaReview> findAllComments(@RequestHeader(value="Authorization") String jwt) {
		uC.verifyJWT(jwt);
		return service.findAllComments();
	}
	
	@RequestMapping(method=RequestMethod.GET,  path="drama/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Object> findDramaComments(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String dramaId) {
		uC.verifyJWT(jwt);
		return service.findDramaComments(dramaId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="avgrating/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public double avgRating(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String dramaId) {
		uC.verifyJWT(jwt);
		return service.avgRating(dramaId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DramaReview findComment(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String commentId) {
		uC.verifyJWT(jwt);
		return service.findComment(commentId);
	}	

	// requestbody should contain userid, dramaid, review or/and rating
	@RequestMapping(method=RequestMethod.POST, path="comment", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DramaReview writeComment(@RequestHeader(value="Authorization") String jwt, @RequestBody DramaReview comment) {		
		uC.verifyJWT(jwt);
		return service.writeComment(comment);
	}
	
}
