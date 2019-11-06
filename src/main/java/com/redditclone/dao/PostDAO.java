package com.redditclone.dao;

import com.redditclone.model.Post;

public interface PostDAO {
	/**
	 * Create Post belong to the topic
	 * @param the uid of the user, the tid of the topic and the Post object 
	 * @return an post id of the post object created
	 */
	public Integer createPost (Integer uid, Integer tid, Post post) throws Exception;
	/**
	 * Update the post 
	 * @param the post object that we want to update 
	 * @return a boolean to indicate that the method is success or not
	 */
	public Boolean updatePost (Post post) throws Exception;
	/**
	 * Delete the post
	 * @param the post id 
	 * @return a boolean to indicate that the method is success or not 
	 */
	public Boolean deletePost(Integer pid) throws Exception;  
}
