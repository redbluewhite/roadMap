package com.roadmap.user;

import com.roadmap.domain.User;

import java.util.List;

public interface UserDao{
	
	//==> INSERT
	public int addUser(User user) throws Exception;
	
	//==> SELECT
	public User getUser(String userEmail) throws Exception ;

	//==> UPDATE
	public int updateUser(User user) throws Exception ;
	
	//==> DELETE 
	public int removeUser(String userEmail) throws Exception;
	
	//==> SELECT
	public List<User> getUserList(User user) throws Exception;
	
}//end of class