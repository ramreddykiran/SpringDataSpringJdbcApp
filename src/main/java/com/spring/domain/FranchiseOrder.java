package com.spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FranchiseOrder {
	
	private String foId;
	private String franchiseeName;
	private String season;
	private Integer year;
	private String targetDeliveryDate;
	private FulfillmentStatus status;
	private String franchiseeLocationName;
	private int orderedQuantity;
	private int fulfilledQuantity;
	
}