package com.spring.employee.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.domain.employee.Employee;

@Repository
public class EmployeeRepository {
	
	private JdbcTemplate springJdbcTemplate;

	//TODO:Need to implement merge query if the employee record already present
	// update it; else insert it
	public void saveEmployee(Employee employee) {
		String query = "";
		springJdbcTemplate.execute(query);
	}

}
