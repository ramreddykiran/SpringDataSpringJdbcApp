package com.spring.employee.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.spring.domain.employee.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private String INSERT_EMPLOYEE="MERGE INTO EMPLOYEE USING DUAL ON (EMPID=? AND EMPNAME=?) "
			+ "WHEN MATCHED THEN UPDATE SET EMPAGE=?,EMPSALARY=?,LST_UPDT_DTTM=SYSDATE "
			+ "WHEN NOT MATCHED THEN INSERT (EMPID,EMPNAME,EMPAGE,EMPSALARY,JOIN_DATE,LEAVING_DATE,CRT_DTTM,LST_UPDT_DTTM) "
			+ "VALUES (?,?,?,?,?,?,SYSDATE,SYSDATE)";
	//TODO:Need to implement merge query if the employee record already present
	// update it; else insert it
	public void saveEmployee(final Employee employee) {
		springJdbcTemplate.execute(INSERT_EMPLOYEE,new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				int index = 1;
				//check query
				ps.setString(index, employee.getEmpId());
				ps.setString(++index,  employee.getEmpName());
				//update query
				ps.setInt(++index, employee.getEmpAge());
				ps.setDouble(++index, employee.getEmpSalary());
				//insert query
				ps.setString(++index, employee.getEmpId());
				ps.setString(++index,  employee.getEmpName());
				ps.setInt(++index, employee.getEmpAge());
				ps.setDouble(++index, employee.getEmpSalary());
				ps.setDate(++index, employee.getJoinDate());
				ps.setDate(++index, employee.getLeavingDate());
				return ps.execute();
			}
		});
	}

}
