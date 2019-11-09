package com.redditclone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redditclone.dao.UserDAO;
import com.redditclone.model.Post;
import com.redditclone.model.User;
import com.redditclone.validator.Validator;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public Integer register(User u) throws Exception {
		try {
			Validator.validateUser(u);
			if (userDAO.emailExists(u.getEmail()))
				throw new Exception("UserService.EMAIL_ALREADY_EXIST");
			if (userDAO.usernameExists(u.getUsername()))
				throw new Exception("UserService.USERNAME_ALREADY_EXIST");
			Integer id = userDAO.register(u);
			return id;
		} catch (Exception e) {
			// Log the exception
			throw e;
		}
	}

	@Override
	public Boolean login(String username, String password) throws Exception {
		try {
			Integer id = userDAO.login(username, password);
			if (id != null) return true;
			throw new Exception("UserService.LOGIN_UNSUCCESSFUL");
		} catch (Exception e) {
			// Log the exception
			throw e;
		}
	}

	@Override
	public Boolean deleteUser(Integer uid) {
		return userDAO.deleteUser(uid);
	}

	@Override
	public List<Post> getUpvotedPosts(Integer uid) {
		return userDAO.getUpvotedPosts(uid);
	}

	@Override
	public List<Post> getDownvotedPosts(Integer uid) {
		return userDAO.getDownvotedPosts(uid);
	}

	@Override
	public List<Post> getSavedPosts(Integer uid) {
		return userDAO.getSavedPosts(uid);
	}

	@Override
	public List<Post> getPosts(Integer uid) {
		return userDAO.getPosts(uid);
	}

	@Override
	public Boolean upvotePost(Integer uid, Integer pid) {
		return userDAO.upvotePost(uid, pid);
	}

	@Override
	public Boolean downvotePost(Integer uid, Integer pid) {
		return userDAO.downvotePost(uid, pid);
	}

	@Override
	public Boolean savePost(Integer uid, Integer pid) {
		return userDAO.savePost(uid, pid);
	}

	@Override
	public Boolean updateUser(User user) throws Exception {
		return userDAO.updateUser(user);
	}

}
