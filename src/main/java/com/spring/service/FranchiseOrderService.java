package com.spring.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.FranchiseOrder;
import com.spring.exception.FranchiseOrderValidationException;
import com.spring.mongo.repository.FracnhiseOrderRepository;

@Service
public class FranchiseOrderService {
	
	@Autowired
	private FracnhiseOrderRepository repository;

	public void saveFranchiseOrder(FranchiseOrder order) {
		validateFranchiseOrder(order);
		repository.saveFracnhiseOrder(order);
	}

	private void validateFranchiseOrder(FranchiseOrder order) {
		if(StringUtils.isBlank(order.getFoId())) {
			throw new FranchiseOrderValidationException("FoId is not present");
		}
	}

}
