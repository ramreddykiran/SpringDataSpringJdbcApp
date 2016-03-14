package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Invoice;
import com.spring.domain.builder.HardTagBuilder;
import com.spring.domain.builder.InvoiceBuilder;
import com.spring.exception.InvoiceValidationException;
import com.spring.mongod.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	public void save(Invoice invoice) throws InvoiceValidationException {
		validateInvoice(invoice);
		Invoice invoiceResponse = prepareInvoce(invoice);
		invoiceRepository.save(invoiceResponse);
	}

	private Invoice prepareInvoce(Invoice invoice) {
		Invoice invoiceBuilder = new InvoiceBuilder().withInvoiceNumber(invoice.getInvoiceNumber())
		.addInvoiceLineItems().withHardTag(new HardTagBuilder().build())
		.addAllcationNumberAndMemoBOL().done()
		.done()
				.build();
		
		return invoiceBuilder;
		
	}

	private void validateInvoice(Invoice invoice) throws InvoiceValidationException {
		if(invoice.getInvoiceNumber() <= 0) {
			throw new InvoiceValidationException("Invoice number should not be <= 0");
		}
		
	}

}
