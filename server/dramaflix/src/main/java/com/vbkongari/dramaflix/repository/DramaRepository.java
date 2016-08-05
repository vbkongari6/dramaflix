package com.vbkongari.dramaflix.repository;

import java.util.List;

import com.vbkongari.dramaflix.entity.Drama;

public interface DramaRepository {

public List<Drama> findAllDramas();
	
	public Drama findOneDrama(String id);
	
	public Drama findDramaByTitle(String title);
	
	public Drama addDrama(Drama drama);
	
	public Drama updateDrama(Drama drama);
	
	public void deleteDrama(Drama drama);	
}
