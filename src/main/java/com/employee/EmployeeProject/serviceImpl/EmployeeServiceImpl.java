package com.employee.EmployeeProject.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeProject.Repository.EmployeeRepository;
import com.employee.EmployeeProject.Service.EmployeeService;
import com.employee.EmployeeProject.dto.EmployeeDto;
import com.employee.EmployeeProject.exceptionHandel.ExceptionHandle;
import com.employee.EmployeeProject.mapper.EmployeeMap;
import com.employee.EmployeeProject.model.Employee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployeeData(EmployeeDto employeeDto) {
		Employee emp =EmployeeMap.mapToEmployee(employeeDto);
		Employee saveEmployeeData=employeeRepository.save(emp);
		return EmployeeMap.mapToEmployeeDto(saveEmployeeData);
	}

	@Override
	public EmployeeDto updateEmployeeData(long emp_id, EmployeeDto employeeDto) {
		Employee em =employeeRepository.findById(emp_id).orElseThrow(()->new ExceptionHandle("Resource Not Found : "+emp_id));
		em.setEmp_name(employeeDto.getEmp_name());
		em.setEmp_company_address(employeeDto.getEmp_company_address());
		em.setEmp_role(employeeDto.getEmp_role());
		em.setEmp_salary(employeeDto.getEmp_salary());
		em.setGender(employeeDto.getGender());
		employeeRepository.save(em);
		return EmployeeMap.mapToEmployeeDto(em);
	}

	@Override
	public void deleEmployee(long emp_id) {
		Employee em =employeeRepository.findById(emp_id).orElseThrow(()->new ExceptionHandle("Resource Not Found : "+emp_id));
		employeeRepository.deleteById(emp_id);
	}

	@Override
	public List<EmployeeDto> getEmployee() {
		List<Employee> emp =employeeRepository.findAll();
		return emp.stream().map((employee)->EmployeeMap.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getEmployeeById(long emp_id) {
		Employee getEmp=employeeRepository.findById(emp_id).orElseThrow(()->new ExceptionHandle("Resource Not Found : "+emp_id));
		return EmployeeMap.mapToEmployeeDto(getEmp);
	}
}
