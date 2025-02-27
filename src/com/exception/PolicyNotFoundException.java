package com.exception;

public class PolicyNotFoundException extends Exception {

private static final long serialVersionUID = 1L;
	
	private String message;

	public PolicyNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
