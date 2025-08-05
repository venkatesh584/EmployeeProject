package com.venkat.student.service;

import java.util.List;

import com.venkat.student.dto.StudentDto;
import com.venkat.student.model.Student;

public interface StudentService {
	
	StudentDto createStudent(StudentDto stDto);
	
	StudentDto getStudentByRollNo(long getRollNo);
	
	List<StudentDto> getStudent();
	
	StudentDto updaeStudent(long getRollNo,StudentDto studentDto);
	
	void deleteStudent(long rollNO);
}
