package com.venkat.student.mapper;

import com.venkat.student.dto.StudentDto;
import com.venkat.student.model.Student;

public class StudentMap {
	
	public static StudentDto mapToStudentDto(Student st) {
		return new StudentDto(st.getRollNo(),st.getStudentName(),st.getBranch(),st.getCGPA(),st.getEmailId());
	}
	
	public static Student mapToStudent(StudentDto stDto) {
		return new Student(stDto.getRollNo(),stDto.getStudentName(),stDto.getBranch(),stDto.getCGPA(),stDto.getEmailId());
	}

}
