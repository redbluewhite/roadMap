package com.roadmap.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;



public class User implements Serializable {
	
	private String userNo;
	private String userEmail;
    private String userName;
    private String password;
    private Timestamp regDate	= new Timestamp(new Date().getTime());
    private String userImage;
    private String twitterID;
    private String facebookID;
    
    private boolean active; 
    
    ///Constructor
    public User() {
	}
    
    public User ( String userEmail, String userName, String password ) {
    	this.userEmail = userEmail;
		this.userName = userName;
		this.password = password;
	}
    
    ///Method (getter/setter)


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}    
	@Override
	public String toString() {
		return "User [user_email=" + userEmail + ", user_name=" + userName 
				+ ", email=" + userEmail + ", password="
				+ password + ", reg_date=" + regDate+ ", active=" + active+ "]";
	}
}//end of class