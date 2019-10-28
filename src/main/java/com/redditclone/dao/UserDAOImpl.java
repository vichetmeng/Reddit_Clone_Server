package com.redditclone.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	EntityManager entityManager;
	
//	public User getAllUsers(String username) {
////		UserEntity ue = entityManager.find(UserEntity.class, username);
////		User u = new User();
////		u.setUsername(ue.getUsername());
////		u.setPassword(ue.getPassword());
////		u.setDateSignedUp(ue.getDateSignedUp());
////		u.setEmail(ue.getEmail());
////		List<CommentEntity> cel = ue.getComments();
////		List<Comment> cl = new ArrayList<>();
////		for (CommentEntity ce : cel) {
////			Comment c = new Comment();
////			c.setId(ce.getId());
////			c.setDateAdded(ce.getDateAdded());
////			c.setBody(ce.getContent());
////			c.setNumOfDownvotes(ce.getNumOfDownvotes());
////			c.setNumOfUpvotes(ce.getNumOfUpvotes());
////			cl.add(c);
////		}
////		u.setComments(cl);
////		return u;
//		return null;
//	}
}
