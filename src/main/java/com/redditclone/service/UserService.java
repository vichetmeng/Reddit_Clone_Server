package com.redditclone.service;

import java.util.List;

import com.redditclone.model.Post;
import com.redditclone.model.User;

public interface UserService {
	/**
	 * 
	 * @param 
	 * @return
	 */
	public Integer register(User u) throws Exception;
	public Boolean login(String username, String password);
	public Boolean deleteUser(Integer uid);
	/**
	 * This function finds all the post upvoted by the user
	 * @param uid the user id of the user
	 * @return a list of posts that were upvoted by the user.
	 */
	public List<Post> getUpvotedPosts(Integer uid);
	/**
	 * This function finds all the post downvoted by the user.
	 * @param uid the user id of the user.
	 * @return a list of posts that were downvoted by the user.
	 */
	public List<Post> getDownvotedPosts(Integer uid);
	/**
	 * This function finds all the post saved by the user.
	 * @param uid the user id of the user.
	 * @return a list of posts that were saved by the user.
	 */
	public List<Post> getSavedPosts(Integer uid);
	/**
	 * This function gets out all the posts posted by this user.
	 * @param uid, the id of the user
	 * @return the list of posts
	 */
	public List<Post> getPosts(Integer uid);
	/**
	 * This function allows the user to upvote a post, this will store the upvoted post in relation to the user
	 * as well as increment the upvotecount of the post.
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully upvoted the post, false otherwise (couldn't found the post or user).
	 */
	public Boolean upvotePost(Integer uid, Integer pid);
	/**
	 * This function allows the user to downvote a post, this will store the downvoted post in relation to the user
	 * as well as increment the downvotecount of the post.
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully downvoted the post, false otherwise (couldn't found the post or user).
	 */
	public Boolean downvotePost(Integer uid, Integer pid);
	/**
	 * This function allows the user to save a post
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully saved the post, false otherwise (couldn't found the post or user).
	 */
	public Boolean savePost(Integer uid, Integer pid);
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Boolean updateUser(User user);
}
