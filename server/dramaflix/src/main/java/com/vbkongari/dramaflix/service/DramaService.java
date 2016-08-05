package com.vbkongari.dramaflix.service;

import java.util.List;

import com.vbkongari.dramaflix.entity.Drama;

public interface DramaService {

	public List<Drama> findAllDramas();
	
	public Drama findOneDrama(String id);
	
	public Drama addDrama(Drama drama);
	
	public Drama updateDrama(String id, Drama drama);
	
	public void deleteDrama(String id);
}
