package com.spring.domain;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FranchiseOrder {
	@Id
	private String foId;
	private String franchiseeName;
	private String season;
	private Integer year;
	private String targetDeliveryDate;
	private FulfillmentStatus status;
	private String franchiseeLocationName;
	private Integer orderedQuantity;
	private Integer fulfilledQuantity;
	
}