package com.redditclone.dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.redditclone.entity.UserEntity;
import com.redditclone.model.Post;
import com.redditclone.utility.HashingUtility;


@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public UserEntity getUser(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Integer login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer register(String username, String password) {
		UserEntity ue = new UserEntity();
		ue.setUsername(username);
		ue.setPasswordHash(HashingUtility.getHashValue(password));
		return null;
	}

	@Override
	public List<Post> getUpvotedPosts(Integer uid) {
		// TODO Auto-generated method stub
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
