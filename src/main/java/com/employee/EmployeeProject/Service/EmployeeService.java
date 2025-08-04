package com.employee.EmployeeProject.Service;

import java.util.List;

import com.employee.EmployeeProject.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployeeData(EmployeeDto employeeDto);
	
	EmployeeDto updateEmployeeData(long emp_id ,EmployeeDto employeeDto);
	
	void deleEmployee(long emp_id);
	
	List<EmployeeDto> getEmployee();
	
	
	EmployeeDto getEmployeeById(long emp_id);

}
