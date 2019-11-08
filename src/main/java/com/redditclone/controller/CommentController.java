package com.redditclone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redditclone.model.Comment;

@RestController
@RequestMapping("comment")
public class CommentController {
	/**
	 * Get all the comment belong to one post
	 * @param the post id 
	 * @return The list of comment belong to that same post id 
	 */
	@RequestMapping(value = "/get/{pid}",method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> getAllComment(@PathVariable Integer pid){
		return null;
	};
	/**
	 * Update a comment
	 * @param the comment object 
	 * @return a boolean to indicate that the method is success or not
	 */
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<String> updateComment(@RequestBody Comment comment) {;
		return null;
	}
	/**
	 * Create a comment
	 * @param a post id, the user id, the comment id of its parent comment, and the comment object
	 * @return the comment id of the comment that is created
	 */
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public ResponseEntity<String>  createComment(@RequestParam Integer pid, @RequestParam Integer uid, 
			@RequestParam Integer parentid,@RequestBody  Comment comment) {
		return null;
	};
	/**
	 * Delete a comment
	 * @param the comment id of the comment	
	 * @return a boolean to indicate that the method is success or not 
	 */
	@RequestMapping(value = "/delete/{cid}",method = RequestMethod.DELETE)
	public ResponseEntity<String>  deleteComment(@PathVariable Integer cid) {
		return null;
	};
}
