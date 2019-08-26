package jp.co.internous.myshop.model.domain;

import lombok.Data;

@Data
public class User {

	private long id;
	
	private String userName;
	
	private String password;
	
	private String fullName;
	
	private int isAdmin;
	
}
