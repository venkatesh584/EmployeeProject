package com.employee.EmployeeProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long emp_id;
	@Column(nullable = false)
	private String emp_name;
	@Column(nullable = false)
	private String emp_company_address;
	@Column(nullable = false)
	private String emp_role;
	@Column
	private int emp_salary;
	@Column
	private String gender;
}
