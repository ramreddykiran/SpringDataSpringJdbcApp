package com.spring.domain.builder;

import java.util.Set;

import org.apache.commons.lang3.builder.Builder;

import com.google.common.collect.Sets;
import com.spring.domain.AllocationNumberAndMemoBOL;
import com.spring.domain.HardTag;
import com.spring.domain.InvoiceLineItem;

interface IInvoiceLineItemBuilder {
	InvoiceBuilder done();
}

public class InvoiceLineItemBuilder implements IInvoiceLineItemBuilder,Builder<InvoiceLineItem>{

	InvoiceBuilder parentBuilder;
	
	private int itemId;
	private String itemDesc;
	private HardTag hardTag;
	private Set<AllocationNumberAndMemoBOLBuilder> allocationNumberAndMemoBOLs = Sets.newHashSet();
	
	public InvoiceLineItemBuilder(InvoiceBuilder parentBuilder) {
		this.parentBuilder = parentBuilder;
	}
	@Override
	public InvoiceLineItem build() {
		InvoiceLineItem invoiceLineItem = new InvoiceLineItem();
		invoiceLineItem.setItemId(itemId);
		invoiceLineItem.setItemDesc(itemDesc);
		invoiceLineItem.setHardTag(hardTag);
		Set<AllocationNumberAndMemoBOL> set = Sets.newHashSet();
		for(AllocationNumberAndMemoBOLBuilder allocationNumAndMemoBOL : allocationNumberAndMemoBOLs) {
			set.add(allocationNumAndMemoBOL.build());
		}
		return invoiceLineItem;
	}
	
	public AllocationNumberAndMemoBOLBuilder addAllcationNumberAndMemoBOL() {
		AllocationNumberAndMemoBOLBuilder builder = new AllocationNumberAndMemoBOLBuilder(this);
		allocationNumberAndMemoBOLs.add(builder);
		return builder;
	}

	@Override
	public InvoiceBuilder done() {
		return this.parentBuilder;
	}
	
	public InvoiceLineItemBuilder withHardTag(HardTag hardTag) {
		this.hardTag = hardTag;
		return this;
	}

}
