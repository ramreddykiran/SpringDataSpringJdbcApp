package com.spring.employee.service;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.employee.Employee;
import com.spring.employee.repository.EmployeeRepository;
import com.spring.exception.EmployeevalidationFailedException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empoloyeeRepository;

	public void saveEmployee(Employee employee) {
		validateEmployee(employee);
		
	}

	private void validateEmployee(Employee employee) {
		if(StringUtils.isBlank(employee.getEmpId()) || StringUtils.isBlank(employee.getEmpName())){
			validateEmployeeSalaryAndAge(employee);
		}
		
	}

	private void validateEmployeeSalaryAndAge(Employee employee) {
		if(Optional.ofNullable(employee.getEmpAge()).isPresent() || Optional.ofNullable(employee.getEmpSalary()).isPresent() || employee.getEmpAge()<=18 || employee.getEmpSalary()<=1000) {
			throw new EmployeevalidationFailedException("employee details not valid : all fields are not nullable. emp salary should be >1000 ; age should be >18");
			
		}
	}
	

}
