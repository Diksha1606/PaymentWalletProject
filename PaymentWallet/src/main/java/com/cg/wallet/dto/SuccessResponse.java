package com.cg.wallet.dto;

public class SuccessResponse {

	public String message;

	public SuccessResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
