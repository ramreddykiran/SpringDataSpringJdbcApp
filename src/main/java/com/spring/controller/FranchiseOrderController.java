package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.FranchiseOrder;
import com.spring.service.FranchiseOrderService;

@Controller
@RequestMapping("franchise-order")
public class FranchiseOrderController {
	
	@Autowired
	private FranchiseOrderService franchiseOrderService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveFranchiseOrder(@RequestBody FranchiseOrder order) {
		franchiseOrderService.saveFranchiseOrder(order);
		return new ResponseEntity<String>("franchise order saved successfully",HttpStatus.OK);
		
	}

}
