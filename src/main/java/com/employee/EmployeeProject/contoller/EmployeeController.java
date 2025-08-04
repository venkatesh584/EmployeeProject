package com.employee.EmployeeProject.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeProject.Service.EmployeeService;
import com.employee.EmployeeProject.dto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedData=employeeService.createEmployeeData(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedData,HttpStatus.CREATED);
		
	}
	@PatchMapping("{id}")
	public ResponseEntity<EmployeeDto> partialyUpdateEmployee(@PathVariable("id") long emp_id, @RequestBody EmployeeDto employeeDto){
		EmployeeDto updateemployee =employeeService.updateEmployeeData(emp_id, employeeDto);
		return new ResponseEntity<EmployeeDto>(updateemployee,HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long emp_id, @RequestBody EmployeeDto employeeDto){
		EmployeeDto updateemployee =employeeService.updateEmployeeData(emp_id, employeeDto);
		return new ResponseEntity<EmployeeDto>(updateemployee,HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(long emp_id){
		employeeService.deleEmployee(emp_id);
		return  ResponseEntity.ok("Employee Deleted Successfully!! "+emp_id);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployee(){
		List<EmployeeDto> getdata=employeeService.getEmployee();
		return new ResponseEntity<List<EmployeeDto>>(getdata,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long emp_id){
		EmployeeDto getEmpData=employeeService.getEmployeeById(emp_id);
		return new ResponseEntity<EmployeeDto>(getEmpData,HttpStatus.OK);
		
	}

}
