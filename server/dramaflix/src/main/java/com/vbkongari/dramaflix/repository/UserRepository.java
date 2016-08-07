package com.vbkongari.dramaflix.repository;

import java.util.List;

import com.vbkongari.dramaflix.entity.User;

public interface UserRepository {

	public List<User> findAllUsers();
	
	public User findUser(String id);
	
	public User findUserByEmail(String email);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(User user);	
}
