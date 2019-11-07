package com.redditclone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.redditclone.model.Post;

@RestController
@RequestMapping("post")
public class PostController {
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
	
	/**
	 * Create Post belong to the topic
	 * @param the uid of the user, the tid of the topic and the Post object 
	 * @return an post id of the post object created
	 */
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public ResponseEntity<String> createPost (@RequestParam Integer uid, @RequestParam Integer tid, @RequestBody Post post) {
		return null;
	};
	/**
	 * Update the post 
	 * @param the post object that we want to update 
	 * @return a boolean to indicate that the method is success or not
	 */
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<String> updatePost (@RequestBody Post post){
		return null; 
	};
	/**
	 * Delete the post
	 * @param the post id 
	 * @return a boolean to indicate that the method is success or not 
	 */
	@RequestMapping(value = "/delete/{pid}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePost(@PathVariable Integer pid) {
		return null;
	};  

}