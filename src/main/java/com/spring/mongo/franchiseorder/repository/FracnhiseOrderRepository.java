package com.spring.mongo.franchiseorder.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.spring.domain.FranchiseOrder;

@Repository
public class FracnhiseOrderRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveFracnhiseOrder(FranchiseOrder order) {
		mongoTemplate.save(order);
	}

}
