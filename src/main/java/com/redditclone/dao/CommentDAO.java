
package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Comment;

public interface CommentDAO {
	public List<Comment> getAllComment(Integer pid);
	public Boolean updateComment(Comment comment) throws Exception;
	public Integer createComment(Integer pid, Integer uid, Integer parentid, Comment comment) throws Exception;
	public Boolean deleteComment(Integer cid) throws Exception;
}
