package com.redditclone.dao;

import com.redditclone.model.Post;

public interface PostDAO {
	public Integer createPost (Integer uid, Post post);
	public Post updatePost (Integer userid, Post post);
	public Boolean deletePostByUser(Integer uid, Integer pid); 
	public Boolean deletePostByTopic(Integer tid, Integer pid); 
}
