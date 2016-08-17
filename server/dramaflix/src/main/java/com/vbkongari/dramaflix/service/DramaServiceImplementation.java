package com.vbkongari.dramaflix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbkongari.dramaflix.entity.Drama;
import com.vbkongari.dramaflix.exception.DramaNotFoundException;
import com.vbkongari.dramaflix.exception.DramaAlreadyExistsException;
import com.vbkongari.dramaflix.repository.DramaRepository;

@Service
public class DramaServiceImplementation implements DramaService{

	@Autowired
	DramaRepository repository;
	
	@Override
	public List<Drama> findAllDramas() {
		return repository.findAllDramas();
	}
	
	@Override
	public List<Drama> findTopRatedDramas(String type) {
		return repository.findTopRatedDramas(type);
	}
	
	@Override
	public List<Drama> filterDramasByType(String type) {
		return repository.filterDramasByType(type);
	}

	@Override
	public List<Drama> filterDramasByYear(int year) {
		return repository.filterDramasByYear(year);
	}

	@Override
	public List<Drama> filterDramasByGenre(String genre) {
		return repository.filterDramasByGenre(genre);
	}
	
	@Override
	public List<Drama> sortDramasBy(String sortBy) {
		return repository.sortDramasBy(sortBy);
	}

	


	@Override
	public Drama findOneDrama(String id) {
		Drama existing = repository.findOneDrama(id);
		if(existing == null) {
			throw new DramaNotFoundException("Drama with id: " + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Drama addDrama(Drama drama) {
		Drama existing = repository.findDramaByTitle(drama.getTitle());
		if(existing != null) {
			throw new DramaAlreadyExistsException("Drama with title: " + drama.getTitle() + " already exists");
		}
		return repository.addDrama(drama);
	}
	
	@Override
	@Transactional
	public List<Drama> addDramas(List<Drama> dramas) {
		List<Drama> dramasAdded = new ArrayList<Drama>();
		for (final Drama drama : dramas) {
			Drama existing = repository.findDramaByTitle(drama.getTitle());
			if(existing != null) {
				throw new DramaAlreadyExistsException("Drama with title: " + drama.getTitle() + " already exists");
			}
			dramasAdded.add(repository.addDrama(drama));
		}		
		return dramasAdded;
	}
	
	
	@Override
	@Transactional
	public Drama updateDrama(String id, Drama drama) {
		Drama existing = repository.findOneDrama(id);
		if(existing == null) {
			throw new DramaNotFoundException("Drama with id: " + id + " not found");
		}
		return repository.updateDrama(drama);
	}

	@Override
	@Transactional
	public void deleteDrama(String id) {
		Drama existing = repository.findOneDrama(id);
		if(existing == null) {
			throw new DramaNotFoundException("Drama with id: " + id + " not found");
		}
		repository.deleteDrama(id, existing);
	}

	

	

	

	
}
