package com.vbkongari.dramaflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vbkongari.dramaflix.entity.User;
import com.vbkongari.dramaflix.service.UserService;

@RestController
@RequestMapping(path="users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAllUsers() {
		return service.findAllUsers();
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findUser(@PathVariable("id") String userId) {
		return service.findUser(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@RequestMapping(method=RequestMethod.PUT, path="{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser(@PathVariable("id") String userId, @RequestBody User user) {
		return service.updateUser(userId, user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void deleteUser(@PathVariable("id") String userId) {
		service.deleteUser(userId);
	}
}
