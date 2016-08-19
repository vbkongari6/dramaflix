package com.vbkongari.dramaflix.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.vbkongari.dramaflix.entity.User;
import com.vbkongari.dramaflix.service.UserService;

@RestController
@RequestMapping(path="users")
public class UserController {	
	
	@Autowired
	UserService service;
	
	public void verifyJWT (String jwt) {
		assert jwt.substring(0, 7).equals("Bearer ");
		jwt = jwt.substring(7);
		
		final String secret = "{{do not try to mess with my db}}";		    
	    
	    try {
	    	final JWTVerifier verifier = new JWTVerifier(secret);
			final Map<String,Object> claims= verifier.verify(jwt);
			
			User user = new User();
			user.setEmail((String) claims.get("email"));
			user.setPassword((String) claims.get("password"));

			service.userAuthentication(user);		
		} 
	    catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | SignatureException
				| IOException | JWTVerifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAllUsers(@RequestHeader(value="Authorization") String jwt) {
		verifyJWT(jwt);
		return service.findAllUsers();
	}	
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findUser(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String userId) {
		verifyJWT(jwt);
		return service.findUser(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object addUser(@RequestBody User user) {
		User userDetails = service.addUser(user);
		return genereateJWT(userDetails);		
	}
	
	@RequestMapping(method=RequestMethod.POST, path="authenticate", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object userAuthentication(@RequestBody User user) {
		return genereateJWT(service.userAuthentication(user));	
	}

	@RequestMapping(method=RequestMethod.PUT, path="{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String userId, @RequestBody User user) {
		verifyJWT(jwt);
		return service.updateUser(userId, user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void deleteUser(@RequestHeader(value="Authorization") String jwt, @PathVariable("id") String userId) {
		verifyJWT(jwt);
		service.deleteUser(userId);
	}
	
	public Object genereateJWT (User userDetails) {		
		final String secret = "{{do not try to mess with my db}}";
		
		final long iat = System.currentTimeMillis() / 1000l; 
		final long exp = iat + 12*24*60*60; 

		final String sub = "User Authentication";
		final String id = ((User) userDetails).getId();
		final String email = ((User) userDetails).getEmail();
		final String password = ((User) userDetails).getPassword();
		final String userType = ((User) userDetails).getUserType();
		
		final JWTSigner signer = new JWTSigner(secret);
		final HashMap<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", sub);
		claims.put("iat", iat);
		claims.put("exp", exp);
		claims.put("id", id);
		claims.put("email", email);
		claims.put("password", password);
		claims.put("userType", userType);

		final HashMap<String, Object> jwt = new HashMap<String, Object>();
		jwt.put("id", id);
		jwt.put("token", signer.sign(claims));
		
		return jwt;
	}	
}
