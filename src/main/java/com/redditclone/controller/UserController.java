package com.redditclone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redditclone.model.Post;
import com.redditclone.model.User;
import com.redditclone.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	Environment environment;
	
	@RequestMapping(value="/getposts/{uid}",method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getPosts(@PathVariable Integer uid) {
		List<Post> list = userService.getPosts(uid);
		if (list == null || list.isEmpty())
			return new ResponseEntity<List<Post>>(list, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Post>>(list, HttpStatus.OK);
	}
	@RequestMapping(value="/getupvotedposts/{uid}",method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getUpvotedPosts(@PathVariable Integer uid) {
		return new ResponseEntity<List<Post>>(new ArrayList<Post>(), HttpStatus.OK);
	}
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody User u) throws Exception{
		try {
			userService.register(u);
			return new ResponseEntity<String>(environment.getProperty("UserController.REGISTER_SUCCESSFUL"), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: Log the exception
			return new ResponseEntity<String>(environment.getProperty(e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody User u) {
		return null;
	}
	@RequestMapping(value="/delete/{uid}",method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable Integer uid) {
		return null;
	}
	@RequestMapping(value="/downvotedposts/{uid}",method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getDownvotedPosts(@PathVariable Integer uid){
		return null;
	}
	@RequestMapping(value="/savedposts/{uid}",method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getSavedPosts(Integer uid){
		return null;
	}
	@RequestMapping(value="/upvotepost",method = RequestMethod.PUT)
	public ResponseEntity<String> upvotePost(@RequestParam Integer uid, @RequestParam Integer pid) {
		return null;
	}
	@RequestMapping(value="/downvotepost",method = RequestMethod.PUT)
	public ResponseEntity<String> downvotePost(@RequestParam Integer uid, @RequestParam Integer pid) {
		return null;
	}
	@RequestMapping(value="/savepost",method = RequestMethod.PUT)
	public ResponseEntity<String> savePost(@RequestParam Integer uid, @RequestParam Integer pid) {
		return null;
	}
	@RequestMapping(value="/update",method =RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		return null;
	}
}
