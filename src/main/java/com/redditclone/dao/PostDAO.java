package com.redditclone.dao;

import com.redditclone.model.Post;

public interface PostDAO {
	public Integer createPost (Integer uid, Integer tid, Post post) throws Exception;
	public Boolean updatePost (Post post) throws Exception;
	public Boolean deletePost(Integer pid) throws Exception;  
}
