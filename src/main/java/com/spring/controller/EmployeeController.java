package com.spring.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.employee.Employee;
import com.spring.service.EmployeeService;

@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		try{
			employeeService.saveEmployee(employee);
			return new ResponseEntity<String>("employee saved successfully", HttpStatus.OK);
		}catch(Exception e) {
			String errorMsg = "Unable to save employee details ";
			log.error(errorMsg + "{}",e.getMessage());
			return new ResponseEntity<String>(errorMsg+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
