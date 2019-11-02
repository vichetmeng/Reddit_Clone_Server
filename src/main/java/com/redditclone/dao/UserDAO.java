package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Post;
import com.redditclone.model.User;

public interface UserDAO {
	public User getUser(Integer uid);
	public Integer login(String username, String password);
	public Boolean usernameExists(String username);
	public Boolean emailExists(String email);
	public Integer register(User user);
	public List<Post> getUpvotedPosts(Integer uid);
	public List<Post> getDownvotedPosts(Integer uid);
	public List<Post> getSavedPosts(Integer uid);
	public List<Post> getPosts(Integer uid);
	public Boolean upvotePost(Integer uid, Integer pid);
	public Boolean downvotePost(Integer uid, Integer pid);
	/**
	 * This function allows the user to save a post
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully saved the post, false otherwise (couldn't found the post or user).
	 */
	public Boolean savePost(Integer uid, Integer pid);
}
