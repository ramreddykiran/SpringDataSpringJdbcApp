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
	private HardTag hardTag;
	
    private Set<AllocationNumberAndMemoBOL> allocationNumberAndMemoBOLs = new HashSet<AllocationNumberAndMemoBOL>();
	
}