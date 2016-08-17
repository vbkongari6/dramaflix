package com.vbkongari.dramaflix.service;

import java.util.List;

import com.vbkongari.dramaflix.entity.Drama;

public interface DramaService {

	public List<Drama> findAllDramas();
	
	public List<Drama> findTopRatedDramas(String type);
	
	public List<Drama> filterDramasByType(String type);
	
	public List<Drama> filterDramasByYear(int year);
	
	public List<Drama> filterDramasByGenre(String genre);
	
	public Drama findOneDrama(String id);
	
	public List<Drama> sortDramasBy(String sortBy);
	
	public Drama addDrama(Drama drama);
	
	public List<Drama> addDramas(List<Drama> dramas);
	
	public Drama updateDrama(String id, Drama drama);
	
	public void deleteDrama(String id);
}