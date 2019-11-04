package com.redditclone.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.redditclone.entity.PostEntity;
import com.redditclone.entity.TopicEntity;
import com.redditclone.entity.UserEntity;
import com.redditclone.model.Post;

@Repository
public class PostDAOImpl implements PostDAO{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Integer createPost(Integer uid, Integer tid, Post post) throws Exception {
		PostEntity pe = new PostEntity(); 
		
		UserEntity ue = em.find(UserEntity.class, uid); 
		TopicEntity te = em.find(TopicEntity.class, tid);
		if (ue==null) throw new Exception("Invalid User");
		if (te==null) throw new Exception("Invalid Topic"); 
		pe.setContent(post.getContent());
		pe.setDateCreated(LocalDateTime.now());
		pe.setPictureUrl(post.getPictureUrl());
		pe.setTitle(post.getTitle());
		pe.setTopic(te);
		pe.setUser(ue);
		em.persist(pe);
		
		return pe.getPid();
	}

	@Override
	public Boolean updatePost(Post post) throws Exception {
		PostEntity pe = em.find(PostEntity.class, post.getPid());
		if (pe==null) throw new Exception("Invalid Post"); 
	
		pe.setContent(post.getContent());
		pe.setPictureUrl(post.getPictureUrl());
		pe.setTitle(post.getTitle());
		em.persist(pe);

		return true;
	}

	@Override
	public Boolean deletePost(Integer pid) throws Exception {
		PostEntity pe = em.find(PostEntity.class, pid);
		if (pe==null) throw new Exception("Invalid Post");
		pe.setTopic(null);
		pe.setUser(null);
		em.remove(pe);
		return true;
	}

}
