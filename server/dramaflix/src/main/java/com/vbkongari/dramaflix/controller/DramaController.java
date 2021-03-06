package com.vbkongari.dramaflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vbkongari.dramaflix.entity.Drama;
import com.vbkongari.dramaflix.service.DramaService;

@RestController
@RequestMapping(path="dramas")
public class DramaController {

	@Autowired
	DramaService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> findAllDramas() {
		return service.findAllDramas();
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="best{type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> findTopRatedDramas(@PathVariable("type") String dramaType) {
		return service.findTopRatedDramas(dramaType);
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="type={type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> filterDramasByType(@PathVariable("type") String dramaType) {
		return service.filterDramasByType(dramaType);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="year={year}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> filterDramasByYear(@PathVariable("year") int dramaYear) {
		return service.filterDramasByYear(dramaYear);
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="genre={genre}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> filterDramasByGenre(@PathVariable("genre") String dramaGenre) {
		return service.filterDramasByGenre(dramaGenre);
	}		
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Drama findOneDrama(@PathVariable("id") String dramaId) {
		return service.findOneDrama(dramaId);
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="sort=year/DESC", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Drama> sortDramasByYearDESC() {
		return service.sortDramasByYearDESC();
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Drama addDrama(@RequestBody Drama drama) {
		return service.addDrama(drama);
	}	
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Drama updateDrama(@PathVariable("id") String dramaId, @RequestBody Drama drama) {
		return service.updateDrama(dramaId, drama);
	}	
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void deleteDrama(@PathVariable("id") String dramaId) {
		service.deleteDrama(dramaId);
	}
}
