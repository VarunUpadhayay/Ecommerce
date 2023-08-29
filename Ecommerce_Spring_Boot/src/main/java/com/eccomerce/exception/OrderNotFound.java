package com.eccomerce.exception;
public class OrderNotFound extends RuntimeException{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OrderNotFound(String message) {
		this.message = message;
	}
	
	
}
