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

/**
 * @author vichetmeng
 *
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public User getUser(Integer uid) {
		UserEntity ue = em.find(UserEntity.class, uid);
		if (ue == null) return null;
		User u = new User();
		u.setUsername(ue.getUsername());
		u.setEmail(ue.getEmail());
		u.setDateJoined(ue.getDateJoined());
		u.setUid(ue.getUid());
		u.setAvatarUrl(ue.getAvatarUrl());
		return u;
	}
 
	
	@Override
	public Integer login(String username, String password) {
		Query q = em.createQuery("Select u from UserEntity u where u.username = :username");
		q.setParameter("username", username);
		List<UserEntity> uel = q.getResultList();
		if (uel.isEmpty()) return null;
		if (uel.get(0).getPasswordHash().equals(HashingUtility.getHashValue(password))) return uel.get(0).getUid();
		return null;
	}

	
	@Override
	public Integer register(User user) {
		UserEntity ue = new UserEntity();
		ue.setUsername(user.getUsername());
		ue.setPasswordHash(HashingUtility.getHashValue(user.getPassword()));
		ue.setDateJoined(LocalDateTime.now());
		ue.setEmail(user.getEmail());
		em.persist(ue);
		return ue.getUid();
	}
	
	@Override
	public List<Post> getUpvotedPosts(Integer uid) {
		UserEntity ue = em.find(UserEntity.class, uid);
		if(ue == null) return null;
		List<PostEntity> pel = ue.getPostsUpvoted();
		List<Post> pl = new ArrayList<>();
		for (PostEntity pe : pel) {
			Post p = new Post();
			p.setPid(pe.getPid());
			p.setDateCreated(pe.getDateCreated());
			p.setDownvoteCount(pe.getDownvoteCount());
			p.setUpvoteCount(pe.getUpvoteCount());
			p.setUid(uid);
			p.setTitle(pe.getTitle());
			p.setContent(pe.getContent());
			pl.add(p);
		}
		return pl;
	}

	
	@Override
	public List<Post> getDownvotedPosts(Integer uid) {
		UserEntity ue = em.find(UserEntity.class, uid);
		if(ue == null) return null;
		List<PostEntity> pel = ue.getPostsDownvoted();
		List<Post> pl = new ArrayList<>();
		for (PostEntity pe : pel) {
			Post p = new Post();
			p.setPid(pe.getPid());
			p.setDateCreated(pe.getDateCreated());
			p.setDownvoteCount(pe.getDownvoteCount());
			p.setUpvoteCount(pe.getUpvoteCount());
			p.setUid(uid);
			p.setTitle(pe.getTitle());
			p.setContent(pe.getContent());
			pl.add(p);
		}
		return pl;
	}

	
	@Override
	public List<Post> getSavedPosts(Integer uid) {
		UserEntity ue = em.find(UserEntity.class, uid);
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
		Query q = em.createQuery("Select u from UserEntity u where u.username = :username");
		q.setParameter("username", username);
		List<UserEntity> uel = q.getResultList();
		if (!uel.isEmpty()) return true;
		return false;
	}

	
	@Override
	public Boolean emailExists(String email) {
		Query q = em.createQuery("Select u from UserEntity u where u.email = :email");
		q.setParameter("email", email);
		List<UserEntity> uel = q.getResultList();
		if (!uel.isEmpty()) return true;
		return false;
	}

	
	@Override
	public List<Post> getPosts(Integer uid) {
		Query q = em.createQuery("Select p from PostEntity p where p.useruid = :uid");
		q.setParameter("uid", uid);
		List<PostEntity> pel = q.getResultList();
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
	public Boolean upvotePost(Integer uid, Integer pid) {
		PostEntity pe = em.find(PostEntity.class, pid);
		UserEntity ue = em.find(UserEntity.class, uid);
		
		// Add the post entity into the ue's upvotedpost
		// increment the post's upvote count by 1
		if (pe == null || ue == null) return false;
		ue.getPostsUpvoted().add(pe);
		pe.setUpvoteCount(pe.getUpvoteCount()+1);
		return true;
	}

	
	@Override
	public Boolean downvotePost(Integer uid, Integer pid) {
		PostEntity pe = em.find(PostEntity.class, pid);
		UserEntity ue = em.find(UserEntity.class, uid);
		
		// Add the post entity into the ue's downvotepost
		// increment the post's downvote count by 1
		if (pe == null || ue == null) return false;
		ue.getPostsDownvoted().add(pe);
		pe.setDownvoteCount(pe.getDownvoteCount()+1);
		return true;
	}

	
	@Override
	public Boolean savePost(Integer uid, Integer pid) {
		PostEntity pe = em.find(PostEntity.class, pid);
		UserEntity ue = em.find(UserEntity.class, uid);
		
		if (pe == null || ue == null) return false;
		ue.getPostsSaved().add(pe);
		return true;
	}



	@Override
	public Boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean deleteUser(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}
}
