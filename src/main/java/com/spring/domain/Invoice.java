package com.spring.domain;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Invoice")
@Getter
@Setter
@JsonSerialize()
public class Invoice {

    @Id
	private int invoiceNumber;
    private String applicationName;
    private String invoiceDate;
    private String invoiceEffectiveDate;
	private int shippingLocationCode;
	private String uniqueShippingIndicator;
	private String partnerNumber;
	private String partnerName; 
	private String orderNumber;
	private String brandName;
	private String seasonName;
	private String countryOfDestination;
	private String currencyCode;
	private double freightCost;
	private String status;
	private Date createdDate ;
	private Date updatedDate;
	
	private List<InvoiceLineItem> invoiceLineItems;
}
