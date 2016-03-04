package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.FranchiseOrder;
import com.spring.repository.FracnhiseOrderRepository;

@Service
public class FranchiseOrderService {
	
	@Autowired
	private FracnhiseOrderRepository repository;

	public void saveFranchiseOrder(FranchiseOrder order) {
		repository.saveFracnhiseOrder(order);
		
	}

}
