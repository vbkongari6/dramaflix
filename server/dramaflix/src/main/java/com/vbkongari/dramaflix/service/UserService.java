package com.vbkongari.dramaflix.service;

import java.util.List;

import com.vbkongari.dramaflix.entity.User;

public interface UserService {

	public List<User> findAllUsers();
	
	public User findUser(String id);
	
	public User userAuthentication(User user);
		
	public User addUser(User user);
	
	public User updateUser(String id, User user);
	
	public void deleteUser(String id);
}
