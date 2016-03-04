package com.spring.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceLineItem {

	private int itemId;
	private String itemDesc;
	private String styleId;
	private String styleDesc;
	private String countryOfOrigin;
	private double itemPrice;
	private int shippedQuantity;
	private String unitOfMeasure; 
	private double weightedAverageCost;	
	private HardTag hardTag;
	
    private Set<AllocationNumberAndMemoBOL> allocationNumberAndMemoBOLs = new HashSet<AllocationNumberAndMemoBOL>();
	
}