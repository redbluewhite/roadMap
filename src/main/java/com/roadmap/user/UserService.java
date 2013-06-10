package com.roadmap.user;

import com.roadmap.domain.User;

import java.util.List;


public interface UserService {
		
	//==> INSERT
	public void addUser(User user) throws Exception;
	
	//==> SELECT
	public User getUser(String userEmail) throws Exception;

	//==> UPDATE
	public void updateUser(User user) throws Exception;
	
	//==> SELECT
	public List<User> getUserList(User user) throws Exception;
}