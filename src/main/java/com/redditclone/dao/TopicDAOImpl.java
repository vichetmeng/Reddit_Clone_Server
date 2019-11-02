package com.redditclone.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.redditclone.entity.PostEntity;
import com.redditclone.entity.TopicEntity;
import com.redditclone.entity.UserEntity;
import com.redditclone.model.Post;
import com.redditclone.model.Topic;
import com.redditclone.model.User;
/**
 * @author vichetmeng
 *
 */
@Repository
@Transactional
public class TopicDAOImpl implements TopicDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer createTopic(Topic topic, Integer uid) {
//		TopicEntity te = new TopicEntity();
//		te.setDateCreated(LocalDateTime.now());
//		te.setName(topic.getName());
//		te.setRules(topic.getRules());
//		te.setDescription(topic.getDescription());
//		UserEntity ue = em.find(UserEntity.class, uid);
//		te.getMemberList().add(ue);
//		te.getMonitorList().add(ue);
//		em.persist(te);
//		return te.getTid();
		return null;
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
		Query q = em.createQuery("Select p from PostEntity p where p.topicid = :topicid");
		q.setParameter("topicid", topicId);
		List<PostEntity> pel = q.getResultList();
		List<Post> pl = new ArrayList<>();
		
		for (PostEntity pe : pel) {
			Post p = new Post();
			p.setPid(pe.getPid());
			p.setTitle(pe.getTitle());
			p.setUpvoteCount(pe.getUpvoteCount());
			p.setDownvoteCount(pe.getDownvoteCount());
			p.setContent(pe.getContent());
			p.setDateCreated(pe.getDateCreated());
			p.setPosterUsername(pe.getUser().getUsername());
			pl.add(p);
		}
		return pl;
	}

	@Override
	public List<User> getMembersInTopic(Integer topicId) {
//		"select u from UserEntity u where u."
//		TopicEntity te = em.find(TopicEntity.class, topicId);
//		List<User> ul = new ArrayList<>();
//		if (te == null) return ul;
//		List<UserEntity> uel = te.getMemberList();
//		for (UserEntity ue : uel) {
//			User u = new User();
//			u.setUid(ue.getUid());
//			u.setUsername(ue.getUsername());
//			u.setEmail(ue.getEmail());
//			u.setAvatarUrl(ue.getAvatarUrl());
//			ul.add(u);
//		}
//		return ul;
		return null;
	}

	@Override
	public Boolean userIsMember(Integer topicId, Integer uid) {
//		TopicEntity te = em.find(TopicEntity.class, topicId);
//		if (te == null) return null;
//		List<UserEntity> uel = te.getMemberList();
//		for (UserEntity ue : uel) {
//			if (ue.getUid().equals(uid)) return true;
//		}
//		return false;
		return null;
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

	@Override
	public Boolean deleteTopic(Integer tid) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
