package com.spring.franchiseorder.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.FranchiseOrder;
import com.spring.franchiseorder.service.FranchiseOrderService;

@Controller
@RequestMapping("franchise-order")
@Slf4j
public class FranchiseOrderController {

	@Autowired
	private FranchiseOrderService franchiseOrderService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveFranchiseOrder(@RequestBody FranchiseOrder order) {
		try {
			franchiseOrderService.saveFranchiseOrder(order);
			return new ResponseEntity<String>("franchise order saved successfully", HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Unable to save franchise order ";
			log.error(errorMsg + " {}", e.getMessage());
			return new ResponseEntity<String>(errorMsg + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
