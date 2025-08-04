package com.employee.EmployeeProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private long emp_id;
	private String emp_name;
	private String emp_company_address;
	private String emp_role;
	private int emp_salary;
	private String gender;

}
