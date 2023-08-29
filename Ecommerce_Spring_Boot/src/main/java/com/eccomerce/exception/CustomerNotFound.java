package com.eccomerce.exception;
public class CustomerNotFound extends RuntimeException{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerNotFound(String message) {
		this.message = message;
	}
	
	
}
