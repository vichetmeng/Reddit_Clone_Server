package com.redditclone.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.redditclone.entity.CommentEntity;
import com.redditclone.entity.PostEntity;
import com.redditclone.entity.UserEntity;
import com.redditclone.model.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Comment> getAllComment(Integer pid) {
		Query q = em.createQuery("SELECT c FROM CommentEntity c WHERE c.postpid = :pid");
		q.setParameter("pid", pid);
		List<CommentEntity> ceList = q.getResultList();
		List<Comment> result = new ArrayList(); 
		for (CommentEntity ce: ceList) {
			Comment c = new Comment();
			c.setCid(ce.getCid());
			c.setContent(ce.getContent());
			c.setDateCreated(ce.getDateCreated());
			c.setDownvoteCount(ce.getDownvoteCount());
			c.setUpvoteCount(ce.getUpvoteCount());
			if (ce.getParentComment()!= null) {
				Comment parent = new Comment();
				parent.setCid(ce.getParentComment().getCid());
				parent.setContent(ce.getParentComment().getContent());
				parent.setDateCreated(ce.getParentComment().getDateCreated());
				parent.setDownvoteCount(ce.getParentComment().getDownvoteCount());
				parent.setUpvoteCount(ce.getParentComment().getUpvoteCount());
				c.setParentComment(parent);
			}
			if (ce.getUser()!=null) {
				c.setUserid(ce.getUser().getUid());
				c.setUsername(ce.getUser().getUsername());
			}
			result.add(c);
		}
		return result; 
	}


	@Override
	public Boolean updateComment(Comment comment) throws Exception {
		CommentEntity ce = em.find(CommentEntity.class, comment.getCid());
		if (ce == null) throw new Exception("Invalid Comment");
		ce.setContent(comment.getContent());
		em.persist(ce);
		
		return true; 
	}
	
	
	@Override
	public Integer createComment(Integer pid, Comment comment, Integer uid, Integer parentid) throws Exception {
		CommentEntity ce = new CommentEntity();
		UserEntity ue = em.find(UserEntity.class, uid);
		if (ue==null) throw new Exception("Invalid User"); 
		PostEntity pe = em.find(PostEntity.class, pid);
		if (pe == null) throw new Exception("Invalid Post");
		CommentEntity parente = em.find(CommentEntity.class, parentid);		
		ce.setContent(comment.getContent());
		ce.setDateCreated(LocalDateTime.now());	
		ce.setPost(pe);
		ce.setUser(ue);
		ce.setParentComment(parente);
		
		em.persist(ce);
		return ce.getCid();
	}

	@Override
	public Boolean deleteComment(Integer cid) throws Exception {
		CommentEntity ce = em.find(CommentEntity.class, cid);
		if (ce == null) throw new Exception("Invalid Comment");
		ce.setPost(null);
		ce.setUser(null);
		ce.setParentComment(null);
		em.remove(ce);
		return true; 
	}

}
