package com.spring.domain.employee;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Employee {
	
	private String empId;
	private String empName;
	private Integer empAge;
	private Double empSalary;
	private Date joinDate;
	private Date leavingDate;

}
