package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Comment;

public interface CommentDAO {
	public List<Comment> getAllComment(Integer pid);
	public Boolean updateComment(Comment comment) throws Exception;
	public Integer createComment(Integer pid, Comment comment, Integer uid, Integer parentid) throws Exception;
	public Boolean deleteComment(Integer cid) throws Exception;
}
