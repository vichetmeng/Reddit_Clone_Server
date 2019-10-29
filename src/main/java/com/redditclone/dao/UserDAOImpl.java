package com.redditclone.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.redditclone.entity.UserEntity;
import com.redditclone.model.Post;
import com.redditclone.model.User;
import com.redditclone.utility.HashingUtility;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User getUser(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Integer login(String username, String password) {
		// TODO Auto-generated method stub

		
		
		
		User u = new User(); 
		return null;
	}

	@Override
	public Integer register(User user) {
		UserEntity ue = new UserEntity();
		ue.setUsername(user.getUsername());
		ue.setPasswordHash(HashingUtility.getHashValue(user.getPassword()));
		ue.setDateJoined(LocalDateTime.now());
		ue.setEmail(user.getEmail());
		entityManager.persist(ue);
		return ue.getUid();
	}
	
	@Override
	public List<Post> getUpvotedPosts(Integer uid) {
		return null;
	}

	@Override
	public List<Post> getDownvotedPosts(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getSavedPosts(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}
}
