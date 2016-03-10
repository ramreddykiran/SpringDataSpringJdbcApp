package com.spring.domain.builder;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.Builder;

import com.google.common.collect.Lists;
import com.spring.domain.Invoice;
import com.spring.domain.InvoiceLineItem;

public class InvoiceBuilder implements Builder<Invoice>{
	
	private int invoiceNumber;
    private String applicationName;
    private String invoiceEffectiveDate;
	private int shippingLocationCode;
	private String seasonName;
	private String countryOfDestination;
	private String currencyCode;
	private double freightCost;
	private String status;
	private Date createdDate ;
	private Date updatedDate;
	
	private List<InvoiceLineItemBuilder> invoiceLineItems = Lists.newArrayList();
	
	public Invoice build() {
		Invoice invoice = new Invoice();
		invoice.setInvoiceNumber(invoiceNumber);
		invoice.setApplicationName(applicationName);
		invoice.setInvoiceEffectiveDate(invoiceEffectiveDate);
		invoice.setShippingLocationCode(shippingLocationCode);
		invoice.setSeasonName(seasonName);
		invoice.setCountryOfDestination(countryOfDestination);
		invoice.setCurrencyCode(currencyCode);
		invoice.setFreightCost(freightCost);
		invoice.setStatus(status);
		invoice.setCreatedDate(createdDate);
		invoice.setUpdatedDate(updatedDate);
		List<InvoiceLineItem> invoiceLineItems = Lists.newArrayList();
		for(InvoiceLineItemBuilder invoiceLineItem : this.invoiceLineItems) {
			invoiceLineItems.add(invoiceLineItem.build());
		}
		invoice.setInvoiceLineItems(invoiceLineItems);
		return invoice;
	}
	
	public InvoiceLineItemBuilder addInvoiceLineItems() {
		InvoiceLineItemBuilder invoiceLineItem = new InvoiceLineItemBuilder(this);
		invoiceLineItems.add(invoiceLineItem);
		return invoiceLineItem;
	}
	
	
	public InvoiceBuilder withInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
		return this;
	}
	
	public InvoiceBuilder withApplicationName(String applicationName) {
		this.applicationName = applicationName;
		return this;
	}

}
