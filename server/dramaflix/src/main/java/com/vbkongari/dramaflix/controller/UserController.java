package com.vbkongari.dramaflix.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTSigner;
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
	public String addUser(@RequestBody User user) {
		User userDetails = service.addUser(user);
		return genereateJWT(userDetails);		
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String userAuthentication(@RequestBody User user) {
//		if (user.getId() != null) {
//			User userDetails = service.findUser(user.getId());
//		}
		User userDetails = service.userAuthentication(user);
		return genereateJWT(userDetails);		
	}
	
	private String genereateJWT (User userDetails) {		
		final String secret = "{{do not try to mess up with my db}}";

		final String sub = "User Authentication";
		final String id = ((User) userDetails).getId();
		final String email = ((User) userDetails).getEmail();
		final String password = ((User) userDetails).getPassword();
		final String userType = ((User) userDetails).getUserType();
		
		final JWTSigner signer = new JWTSigner(secret);
		final HashMap<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", sub);
		claims.put("id", id);
		claims.put("email", email);
		claims.put("password", password);
		claims.put("userType", userType);

		final String jwt = signer.sign(claims);
		
		return jwt;
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
