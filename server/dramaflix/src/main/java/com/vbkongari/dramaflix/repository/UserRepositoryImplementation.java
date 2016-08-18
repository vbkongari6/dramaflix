package com.vbkongari.dramaflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.vbkongari.dramaflix.entity.User;

@Repository
public class UserRepositoryImplementation  implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createNamedQuery("User.findAllUsers", User.class);
		return query.getResultList();
	}
	
	@Override
	public User findUser(String id) {
		return em.find(User.class, id);
	}

	@Override
	public User findUserByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findUserByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if(users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User addUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return em.merge(user);
	}

	@Override
	public void deleteUser(User user) {		
		em.remove(user);
	}

	
	

}
