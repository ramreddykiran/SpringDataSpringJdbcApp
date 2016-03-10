package com.spring.domain.builder;

import org.apache.commons.lang3.builder.Builder;

import com.spring.domain.AllocationNumberAndMemoBOL;

interface IAllocationNumberAndMemoBOLBuilder{
	InvoiceLineItemBuilder done();
}

public class AllocationNumberAndMemoBOLBuilder implements IAllocationNumberAndMemoBOLBuilder,Builder<AllocationNumberAndMemoBOL>{
	
	private InvoiceLineItemBuilder parentBuilder;
	private Long allocationNumber;
    private String memoBOL;
    
	public AllocationNumberAndMemoBOLBuilder(InvoiceLineItemBuilder parentBuilder){
		this.parentBuilder = parentBuilder;
	}
	
	@Override
	public AllocationNumberAndMemoBOL build() {
		AllocationNumberAndMemoBOL allocationNumberMemoBOL = new AllocationNumberAndMemoBOL();
		allocationNumberMemoBOL.setAllocationNumber(allocationNumber);
		allocationNumberMemoBOL.setMemoBOL(memoBOL);
		return allocationNumberMemoBOL;
	}

	@Override
	public InvoiceLineItemBuilder done() {
		return this.parentBuilder;
	}

}
