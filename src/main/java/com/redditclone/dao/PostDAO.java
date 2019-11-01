package com.redditclone.dao;

import com.redditclone.model.Post;

public interface PostDAO {
	public Integer createPost (Integer uid, Integer tid, Post post);
	public Post updatePost (Post post);
	public Boolean deletePost(Integer pid);  
}
