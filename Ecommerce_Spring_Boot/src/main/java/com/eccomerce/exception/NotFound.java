package com.eccomerce.exception;
public class NotFound extends RuntimeException{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotFound(String message) {
		this.message = message;
	}
	
	
}
