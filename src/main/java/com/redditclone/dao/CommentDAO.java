package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Comment;

public interface CommentDAO {
	public List<Comment> getAllComment(Integer pid);
	public Comment updateComment(Comment comment);
	public Integer createComment(Integer pid, Comment comment, Integer uid, Integer parentid);
	public Boolean deleteComment(Integer cid);
}
