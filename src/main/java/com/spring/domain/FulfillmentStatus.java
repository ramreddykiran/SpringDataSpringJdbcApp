package com.spring.domain;

public enum FulfillmentStatus {

	PENDING("Pending"), 
	PARTIAL("Partial"), 
	COMPLETE("Complete"),
	OPEN("Open");

	private String code;

	FulfillmentStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static FulfillmentStatus findByCode(String code) {
		for (FulfillmentStatus status : FulfillmentStatus.values()) {
			if (status.getCode().equalsIgnoreCase(code)) {
				return status;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return code;
	}

}