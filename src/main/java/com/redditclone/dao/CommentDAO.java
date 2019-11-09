
package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Comment;

public interface CommentDAO {
	/**
	 * Get all the comment belong to one post
	 * @param the post id 
	 * @return The list of comment belong to that same post id 
	 */
	public List<Comment> getAllComment(Integer pid);
	/**
	 * Update a comment
	 * @param the comment object 
	 * @return a boolean to indicate that the method is success or not
	 */
	public Boolean updateComment(Comment comment) throws Exception;
	/**
	 * 
	 * @param pid
	 * @param uid
	 * @param parentid
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public Integer createComment(Integer pid, Integer uid, Integer parentid, Comment comment) throws Exception;
	/**
	 * Delete a comment
	 * @param the comment id of the comment	
	 * @return a boolean to indicate that the method is success or not 
	 */
	public Boolean deleteComment(Integer cid) throws Exception;
}
