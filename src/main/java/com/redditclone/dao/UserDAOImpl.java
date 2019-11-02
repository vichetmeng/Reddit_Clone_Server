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
 
	/**
	 * This function login the user by comparing the password.
	 * @param username the user's username.
	 * @param password the user's password.
	 * @return null if the username or password is invalid, uid otherwise.
	 */
	@Override
	public Integer login(String username, String password) {
		Query q = em.createQuery("Select u from UserEntity u where u.username = :username");
		q.setParameter("username", username);
		List<UserEntity> uel = q.getResultList();
		if (uel.isEmpty()) return null;
		if (uel.get(0).getPasswordHash().equals(HashingUtility.getHashValue(password))) return uel.get(0).getUid();
		return null;
	}

	/**
	 * This function registers the user.
	 * @param user object containing username, password and email of the user.
	 * @return the id of the user after it was inserted into the database.
	 */
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
	/**
	 * This function finds all the post upvoted by the user
	 * @param uid the user id of the user
	 * @return a list of posts that were upvoted by the user.
	 */
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

	/**
	 * This function finds all the post downvoted by the user.
	 * @param uid the user id of the user.
	 * @return a list of posts that were downvoted by the user.
	 */
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

	/**
	 * This function finds all the post saved by the user.
	 * @param uid the user id of the user.
	 * @return a list of posts that were saved by the user.
	 */
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

	/**
	 * This function check if the username is already existed in the database.
	 * @param username, the username that you want to check.
	 * @return true if it is already existed in DB, false otherwise.
	 */
	@Override
	public Boolean usernameExists(String username) {
		Query q = em.createQuery("Select u from UserEntity u where u.username = :username");
		q.setParameter("username", username);
		List<UserEntity> uel = q.getResultList();
		if (!uel.isEmpty()) return true;
		return false;
	}

	/**
	 * This function check if the user's email is already existed in the database.
	 * @param email, the email that you want to check.
	 * @return true if the email is already in the database, false otherwise.
	 */
	@Override
	public Boolean emailExists(String email) {
		Query q = em.createQuery("Select u from UserEntity u where u.email = :email");
		q.setParameter("email", email);
		List<UserEntity> uel = q.getResultList();
		if (!uel.isEmpty()) return true;
		return false;
	}

	/**
	 * This function gets out all the posts posted by this user.
	 * @param uid, the id of the user
	 * @return the list of posts
	 */
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
	/**
	 * This function allows the user to upvote a post, this will store the upvoted post in relation to the user
	 * as well as increment the upvotecount of the post.
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully upvoted the post, false otherwise (couldn't found the post or user).
	 */
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

	/**
	 * This function allows the user to downvote a post, this will store the downvoted post in relation to the user
	 * as well as increment the downvotecount of the post.
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully downvoted the post, false otherwise (couldn't found the post or user).
	 */
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
}
