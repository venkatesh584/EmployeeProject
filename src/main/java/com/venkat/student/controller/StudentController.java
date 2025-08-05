package com.venkat.student.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.student.dto.StudentDto;
import com.venkat.student.service.StudentService;

@RestController
@RequestMapping("/app/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto stDto){
		StudentDto	savestudent=studentService.createStudent(stDto);
		return new ResponseEntity<StudentDto>(savestudent,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("id") long getRollNo){
		StudentDto	getStudent=studentService.getStudentByRollNo(getRollNo);
		return new ResponseEntity<StudentDto>(getStudent,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAllStudent(){
		List<StudentDto> getAllStudent =studentService.getStudent();
		return new ResponseEntity<List<StudentDto>>(getAllStudent,HttpStatus.OK);
		
	}
	@PatchMapping("{id}")
	public ResponseEntity<StudentDto> updaeStudent(@PathVariable("id") long getRollNo, @RequestBody StudentDto studentDto){
		StudentDto	getStudent=studentService.updaeStudent(getRollNo, studentDto);
		return new ResponseEntity<StudentDto>(getStudent,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long getRollNo){
		studentService.deleteStudent(getRollNo);
		return  ResponseEntity.ok("Student Deleted Successfully of RollNo: "+getRollNo);
	}
}
