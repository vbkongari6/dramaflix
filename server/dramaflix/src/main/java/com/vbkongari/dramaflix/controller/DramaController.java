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

import com.vbkongari.dramaflix.entity.Drama;
import com.vbkongari.dramaflix.exception.UnauthorizedException;
import com.vbkongari.dramaflix.service.DramaService;

@RestController
@RequestMapping(path="dramas")
public class DramaController {

	@Autowired
	DramaService service;
	
	@Autowired
	UserController uC;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> findAllDramas(@RequestHeader(value="Authorization") String jwt) {
		uC.verifyJWT(jwt);
		return service.findAllDramas();
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="best{type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> findTopRatedDramas(@RequestHeader(value="Authorization") String jwt, @PathVariable("type") String dramaType) {
		uC.verifyJWT(jwt);
		return service.findTopRatedDramas(dramaType);
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="type={type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> filterDramasByType(@RequestHeader(value="Authorization") String jwt, @PathVariable("type") String dramaType) {
		uC.verifyJWT(jwt);
		return service.filterDramasByType(dramaType);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="year={year}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> filterDramasByYear(@RequestHeader(value="Authorization") String jwt, @PathVariable("year") int dramaYear) {
		uC.verifyJWT(jwt);
		return service.filterDramasByYear(dramaYear);
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="genre={genre}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> filterDramasByGenre(@RequestHeader(value="Authorization") String jwt, @PathVariable("genre") String dramaGenre) {
		uC.verifyJWT(jwt);
		return service.filterDramasByGenre(dramaGenre);
	}		
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Drama findOneDrama(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String dramaId) {
		uC.verifyJWT(jwt);
		return service.findOneDrama(dramaId);
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="sort={sortBy}/DESC", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> sortDramasBy(@RequestHeader(value="Authorization") String jwt, @PathVariable("sortBy") String sortBy) {
		uC.verifyJWT(jwt);
		return service.sortDramasBy(sortBy);
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Drama addDrama(@RequestHeader(value="Authorization") String jwt, @RequestBody Drama drama) {
		uC.verifyJWT(jwt);
		return service.addDrama(drama);
	}	
	
	@RequestMapping(method=RequestMethod.POST, path="many", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> addDramas(@RequestHeader(value="Authorization") String jwt, @RequestBody List<Drama> dramas) {
		uC.verifyJWT(jwt);
		return service.addDramas(dramas);
	}	
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Drama updateDrama(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String dramaId, @RequestBody Drama drama) {
		uC.verifyJWT(jwt);
		return service.updateDrama(dramaId, drama);
	}	
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void deleteDrama(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String dramaId) {
		if ((uC.verifyJWT(jwt)).equals("admin")) {
			service.deleteDrama(dramaId);
		}
		else {
			throw new UnauthorizedException("Access Unauthorized");
		}
	}
}
