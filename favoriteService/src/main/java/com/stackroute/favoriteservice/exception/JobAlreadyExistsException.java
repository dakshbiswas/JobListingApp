package com.stackroute.favoriteservice.exception;

public class JobAlreadyExistsException extends Exception {
private String message;
	
	public JobAlreadyExistsException(String message) {
		super(message);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
