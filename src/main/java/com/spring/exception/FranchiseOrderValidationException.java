package com.spring.exception;

public class FranchiseOrderValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	String errorMessage;
	
	public FranchiseOrderValidationException() {
		super();
	}

	public FranchiseOrderValidationException(String errorMessage) {
		super(errorMessage);
		this.errorMessage=errorMessage;
	}
}
