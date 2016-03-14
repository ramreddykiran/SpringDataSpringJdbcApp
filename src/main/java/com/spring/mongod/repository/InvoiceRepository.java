package com.spring.mongod.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.spring.domain.Invoice;

@Repository
public class InvoiceRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(Invoice invoice) {
		mongoTemplate.save(invoice);
	}

}
