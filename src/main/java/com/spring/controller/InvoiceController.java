package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.Invoice;
import com.spring.service.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveInvoice(@RequestBody Invoice invoice) {
		try{
			invoiceService.save(invoice);
			return new ResponseEntity<String>("Invoice saved successfully ",HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("failed to save invoice ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
