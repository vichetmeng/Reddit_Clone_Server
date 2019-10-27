package com.redditclone.dao;

import com.redditclone.model.User;

public interface UserDAO {
	public User getAllUsers(String username);
}
