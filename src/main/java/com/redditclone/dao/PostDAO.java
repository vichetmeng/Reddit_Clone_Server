<<<<<<< HEAD
package com.redditclone.dao;

import com.redditclone.model.Post;

public interface PostDAO {
	public Integer createPost (Integer uid, Integer tid, Post post) throws Exception;
	public Boolean updatePost (Post post) throws Exception;
	public Boolean deletePost(Integer pid) throws Exception;  
}
=======
package com.redditclone.dao;

import com.redditclone.model.Post;

public interface PostDAO {
	public Integer createPost (Integer uid, Integer tid, Post post);
	public Post updatePost (Post post);
	public Boolean deletePost(Integer pid);  
}
>>>>>>> 325313ccd2c7f7332b2b6b05bf3ddff2eed79922
