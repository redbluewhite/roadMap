package com.roadmap.user.impl;

import com.roadmap.domain.User;
import com.roadmap.user.UserDao;
import com.roadmap.user.UserService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	///Field
	@Inject
	@Named("iBatisUserDaoImpl")
	UserDao userDAO;

	public void setUserDAO(UserDao userDAO) {
		System.out.println("::"+getClass()+".setUserDAO  Call.....");
		this.userDAO = userDAO;
	}
	
	///Constructor
	public UserServiceImpl() {
		System.out.println("::"+getClass()+" Default Costructor ...");
	}

	///Method
	//==> INSERT
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
	}
	//==> SELECT
	public User getUser(String userEmail) throws Exception {
		return userDAO.getUser(userEmail);
	}
	//==> UPDATE
	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
	}
	//==> SELECT
	public List<User> getUserList(User user) throws Exception {
		return userDAO.getUserList(user);
	}
}