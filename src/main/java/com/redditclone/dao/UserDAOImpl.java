package com.redditclone.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.redditclone.entity.PostEntity;
import com.redditclone.entity.UserEntity;
import com.redditclone.model.Post;
import com.redditclone.model.User;
import com.redditclone.utility.HashingUtility;

@Repository
@Transactional
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
		User myUser = new User(); 
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
		Post p = new Post();
		return null;
	}

	@Override
	public List<Post> getDownvotedPosts(Integer uid) {
		return null;
	}

	@Override
	public List<Post> getSavedPosts(Integer uid) {
		UserEntity ue = entityManager.find(UserEntity.class, uid);
		List<PostEntity> pel = ue.getPostsSaved();
		List<Post> pl = new ArrayList<>();
		for (PostEntity pe : pel) {
			Post p = new Post();
			p.setPid(pe.getPid());
			p.setTitle(pe.getTitle());
			p.setContent(pe.getContent());
			p.setDateCreated(pe.getDateCreated());
			p.setDownvoteCount(pe.getDownvoteCount());
			p.setUpvoteCount(pe.getDownvoteCount());
			pl.add(p);
		}
		return pl;
	}

	@Override
	public Boolean usernameExists(String username) {
		Query q = entityManager.createQuery("Select u from UserEntity u where u.username = :username");
		q.setParameter("username", username);
		UserEntity ue = (UserEntity) q.getSingleResult();
		if (ue != null) return true;
		return false;
	}

	@Override
	public Boolean emailExists(String email) {
		Query q = entityManager.createQuery("Select u from UserEntity u where u.email = :email");
		q.setParameter("email", email);
		UserEntity ue = (UserEntity) q.getSingleResult();
		if (ue != null) return true;
		return false;
	}

	@Override
	public List<Post> getPosts(Integer uid) {
//		UserEntity ue = entityManager.find(UserEntity.class, uid);
//		List<PostEntity> pel = ue.getPostList();
//		List<Post> pl = new ArrayList<>();
//		for (PostEntity pe : pel) {
//			Post p = new Post();
//			p.setPid(pe.getPid());
//			p.setTitle(pe.getTitle());
//			p.setContent(pe.getContent());
//			p.setDateCreated(pe.getDateCreated());
//			p.setDownvoteCount(pe.getDownvoteCount());
//			p.setUpvoteCount(pe.getDownvoteCount());
//			pl.add(p);
//		}
//		return pl;
		return null;
	}
}
