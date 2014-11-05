package com.rest.chat.domain;

import java.io.Serializable;



public class UserDocument implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long userId;
	
	private String userName;
	
	private String email;
	
	private String createdDate;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
