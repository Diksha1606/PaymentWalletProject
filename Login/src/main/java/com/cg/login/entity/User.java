package com.cg.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cap_login")
public class User {
	
	@Id
	@Column(name = "user_id", length = 45)
	private String userID;
	
	@JsonIgnore
	@Column(name = "password", length = 45)
	private String password;
	
	@Column(name = "user_name", length = 45)
	private String userName;
	
	@Column(name ="role", length = 45)
	private String role;
	
	public User() {
		
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
