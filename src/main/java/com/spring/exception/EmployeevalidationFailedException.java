package com.spring.exception;

public class EmployeevalidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    String errorMessage;
	
	public EmployeevalidationFailedException() {
		super();
	}

	public EmployeevalidationFailedException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
}
