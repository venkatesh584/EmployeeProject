package com.employee.EmployeeProject.mapper;

import com.employee.EmployeeProject.Repository.EmployeeRepository;
import com.employee.EmployeeProject.dto.EmployeeDto;
import com.employee.EmployeeProject.model.Employee;

public class EmployeeMap {
	
	public static EmployeeDto mapToEmployeeDto(Employee emp) {
		return new EmployeeDto(emp.getEmp_id(),emp.getEmp_name(),emp.getEmp_company_address(),emp.getEmp_role(),emp.getEmp_salary(),emp.getGender());
	}
	public static Employee mapToEmployee(EmployeeDto empdto) {
		return new Employee(empdto.getEmp_id(),empdto.getEmp_name(),empdto.getEmp_company_address(),empdto.getEmp_role(),empdto.getEmp_salary(),empdto.getGender());
	}

}
