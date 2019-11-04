<<<<<<< HEAD
package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Comment;

public interface CommentDAO {
	public List<Comment> getAllComment(Integer pid);
	public Boolean updateComment(Comment comment) throws Exception;
	public Integer createComment(Integer pid, Comment comment, Integer uid, Integer parentid) throws Exception;
	public Boolean deleteComment(Integer cid) throws Exception;
}
=======
package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Comment;

public interface CommentDAO {
	public List<Comment> getAllComment(Integer pid);
	public Comment updateComment(Comment comment);
	public Integer createComment(Integer pid, Comment comment, Integer uid, Integer parentid);
	public Boolean deleteComment(Integer cid);
}
>>>>>>> 325313ccd2c7f7332b2b6b05bf3ddff2eed79922
