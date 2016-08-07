package com.vbkongari.dramaflix.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vbkongari.dramaflix.entity.DramaReview;

@RestController
public class DramaReviewController {

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DramaReview writeReview(@RequestBody DramaReview review) {
		return null; //service.writeReview(review);
	}
	
}
