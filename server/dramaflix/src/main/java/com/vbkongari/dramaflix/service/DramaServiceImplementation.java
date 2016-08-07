package com.vbkongari.dramaflix.service;

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
	public List<Drama> findTopRatedIMDBMovies() {
		return repository.findTopRatedIMDBMovies();
	}
	
	@Override
	public List<Drama> findTopRatedIMDBTVSeries() {
		return repository.findTopRatedIMDBTVSeries();
	}
	
	@Override
	public List<Drama> findDramaByType(String type) {
		return repository.findDramaByType(type);
	}

	@Override
	public List<Drama> findDramaByYear(int year) {
		return repository.findDramaByYear(year);
	}

	@Override
	public List<Drama> findDramaByGenre(String genre) {
		return repository.findDramaByGenre(genre);
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
		repository.deleteDrama(existing);
	}

	

	
}
