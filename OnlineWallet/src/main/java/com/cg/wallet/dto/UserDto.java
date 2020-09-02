package com.cg.wallet.dto;

public class UserDto {
	private String  phoneNo;
	private double balance;
	private String userName;
	private String password;
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
	public UserDto() {
		super();
	}
	public UserDto(String phoneNo, double balance, String userName, String password) {
		super();
		this.phoneNo = phoneNo;
		this.balance = balance;
		this.userName = userName;
		this.password = password;
	}
	
}
