package com.vbkongari.dramaflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbkongari.dramaflix.entity.User;
import com.vbkongari.dramaflix.exception.UserAlreadyExistsException;
import com.vbkongari.dramaflix.exception.UserNotFoundException;
import com.vbkongari.dramaflix.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository repository;

	@Override
	public List<User> findAllUsers() {
		return repository.findAllUsers();
	}

	@Override
	public User findUser(String id) {
		User existing = repository.findUser(id);
		if(existing == null) {
			throw new UserNotFoundException("User with id: " + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public User addUser(User user) {
		User existing = repository.findUserByEmail(user.getEmail());
		if(existing != null) {
			throw new UserAlreadyExistsException("User with email: " + user.getEmail() + " already exists");
		}
		return repository.addUser(user);
	}

	@Override
	@Transactional
	public User updateUser(String id, User user) {
		User existing = repository.findUser(id);
		if(existing == null) {
			throw new UserNotFoundException("User with id: " + id + " not found");
		}
		return repository.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		User existing = repository.findUser(id);
		if(existing == null) {
			throw new UserNotFoundException("User with id: " + id + " not found");
		}
		repository.deleteUser(existing);		
	}

}
