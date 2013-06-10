package com.roadmap.user.impl;

import com.roadmap.domain.User;
import com.roadmap.user.UserDao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;


@Repository("iBatisUserDaoImpl")
public class IBatisUserDaoImpl implements UserDao{
	///Field
	@Inject
	@Named("sqlMapClient")
	private SqlMapClient sqlMapClient;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		System.out.println("::"+getClass()+".setSqlMapClient  Call.....");
		this.sqlMapClient = sqlMapClient;
	}

	///Constructor
	public IBatisUserDaoImpl() {
		super();
		System.out.println("::"+getClass()+" Default Contructor .....");
	}
	
	///Method
	//==> INSERT
	public int addUser(User user) throws Exception{
		if( sqlMapClient.insert("User.addUser",user) == null ){
			return 1;
		}
		return 0;
	}//end of method
	
	//==> SELECT
	public User getUser(String userEmail) throws Exception {
		 return (User)sqlMapClient.queryForObject("User.getUser",userEmail);
	}//end of method

	//==> UPDATE
	public int updateUser(User user) throws Exception {
		return sqlMapClient.update("User.updateUser",user);
	}//end of method
	
	//==> DELETE
	public int removeUser(String userEmail) throws Exception{
		return sqlMapClient.delete("User.removeUser", userEmail );
	}
	
	//==> SELECT
	public List<User> getUserList(User user) throws Exception {
		return sqlMapClient.queryForList("User.getUserList",user);	
	}//end of Method

}//end of class