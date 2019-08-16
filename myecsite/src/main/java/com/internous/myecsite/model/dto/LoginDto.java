package com.internous.myecsite.model.dto;

import com.internous.myecsite.model.entity.User;

public class LoginDto {

	private String userName;
	private String password;
	private String fullName;
	
	public LoginDto() {}
	
	public LoginDto(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.fullName = user.getFullName();
	}
	
	public LoginDto(String userName, String password, String fullName) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
