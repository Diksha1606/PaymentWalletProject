package com.cg.login.dto;

import java.util.List;

public class ErrorInfo {
	public String message;
	
	public String code;
	
	public List<String> messages;
	
	
	
	
	
	public ErrorInfo(String message, String code) {
		super();
		this.message = message;
		this.code = code;
		this.messages = messages;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	

}
