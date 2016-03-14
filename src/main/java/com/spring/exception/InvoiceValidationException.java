package com.spring.exception;

public class InvoiceValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvoiceValidationException(String errorMessage) {
		super(errorMessage);
	}
	
	public InvoiceValidationException() {
		super();
	}

}
