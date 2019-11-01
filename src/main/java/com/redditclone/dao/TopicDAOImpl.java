package com.redditclone.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redditclone.entity.PostEntity;
import com.redditclone.entity.TopicEntity;
import com.redditclone.entity.UserEntity;
import com.redditclone.model.Post;
import com.redditclone.model.Topic;
import com.redditclone.model.User;

public class TopicDAOImpl implements TopicDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer createTopic(Topic topic, Integer uid) {
		TopicEntity te = new TopicEntity();
		te.setDateCreated(LocalDateTime.now());
		te.setName(topic.getName());
		te.setRules(topic.getRules());
		te.setDescription(topic.getDescription());
		UserEntity ue = em.find(UserEntity.class, uid);
		te.getMemberList().add(ue);
		te.getMonitorList().add(ue);
		em.persist(te);
		return te.getTid();
	}

	@Override
	public Integer updateTopic(Topic t) {
		TopicEntity te = em.find(TopicEntity.class, t.getTid());
		if (te == null) return null;
		te.setName(t.getName());
		te.setDescription(t.getDescription());
		te.setRules(t.getRules());
		
		return te.getTid();
	}
	
	@Override
	public Topic getTopic(Integer topicId) {
		TopicEntity te = em.find(TopicEntity.class, topicId);
		if (te != null) {
			Topic t = new Topic();
			t.setTid(te.getTid());
			t.setName(te.getName());
			t.setDateCreated(te.getDateCreated());
			t.setDescription(te.getDescription());
			t.setRules(te.getRules());
			return t;
		}
		return null;
	}

	@Override
	public List<Post> getPostsInTopic(Integer topicId) {
//		TopicEntity te = em.find(TopicEntity.class, topicId);
//		List<Post> pl = new ArrayList<>();
//		if (te != null) {
//			List<PostEntity> pel = te.getPostlist();
//			
//			for (PostEntity pe : pel) {
//				Post p = new Post();
//				p.setPid(pe.getPid());
//				p.setTitle(pe.getTitle());
//				p.setUpvoteCount(pe.getUpvoteCount());
//				p.setDownvoteCount(pe.getDownvoteCount());
//				//p.setPictureUrl(pe.getPictureUrl());
//				p.setContent(pe.getContent());
//				p.setDateCreated(pe.getDateCreated());
//				p.setUser(pe.getUser());
//				pl.add(p);
//			}
//		}
//		return pl;
		return null;
	}

	@Override
	public List<User> getMembersInTopic(Integer topicId) {
		TopicEntity te = em.find(TopicEntity.class, topicId);
		List<User> ul = new ArrayList<>();
		if (te == null) return ul;
		List<UserEntity> uel = te.getMemberList();
		for (UserEntity ue : uel) {
			User u = new User();
			u.setUid(ue.getUid());
			u.setUsername(ue.getUsername());
			u.setEmail(ue.getEmail());
			u.setAvatarUrl(ue.getAvatarUrl());
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Boolean userIsMember(Integer topicId, Integer uid) {
		TopicEntity te = em.find(TopicEntity.class, topicId);
		if (te == null) return null;
		List<UserEntity> uel = te.getMemberList();
		for (UserEntity ue : uel) {
			if (ue.getUid().equals(uid)) return true;
		}
		return false;
	}

	@Override
	public Boolean userIsMonitor(Integer topicId, Integer uid) {
		TopicEntity te = em.find(TopicEntity.class, topicId);
		if (te == null) return null;
		List<UserEntity> uel = te.getMonitorList();
		for (UserEntity ue : uel) {
			if (ue.getUid().equals(uid)) return true;
		}
		return false;
	}

	

}
