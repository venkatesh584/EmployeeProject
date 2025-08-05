package com.venkat.student.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkat.student.dto.StudentDto;
import com.venkat.student.exception.HandelExceptions;
import com.venkat.student.mapper.StudentMap;
import com.venkat.student.model.Student;
import com.venkat.student.repository.StudentRepository;
import com.venkat.student.service.StudentService;

@Service
public class StudentServieImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	public StudentServieImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public StudentDto createStudent(StudentDto stDto) {
		Student st =StudentMap.mapToStudent(stDto);
		Student saveStudent =studentRepository.save(st);
		return StudentMap.mapToStudentDto(saveStudent);
	}

	@Override
	public StudentDto getStudentByRollNo(long getRollNo) {
		Student getStudent =studentRepository.findById(getRollNo).orElseThrow(()->new HandelExceptions("Resource Not found: "+getRollNo));
		return StudentMap.mapToStudentDto(getStudent);
	}

	@Override
	public List<StudentDto> getStudent() {
		List<Student> st =studentRepository.findAll();
		return st.stream().map((stt)->StudentMap.mapToStudentDto(stt)).collect(Collectors.toList());
	}

	@Override
	public StudentDto updaeStudent(long getRollNo, StudentDto studentDto) {
		Student updatedStudent =studentRepository.findById(getRollNo).orElseThrow(()->new HandelExceptions("Resource Not found: "+getRollNo));
		updatedStudent.setStudentName(studentDto.getStudentName());
		updatedStudent.setBranch(studentDto.getBranch());
		updatedStudent.setCGPA(studentDto.getCGPA());
		updatedStudent.setEmailId(studentDto.getEmailId());
		 updatedStudent =studentRepository.save(updatedStudent);
		return StudentMap.mapToStudentDto(updatedStudent);
	}

	@Override
	public void deleteStudent(long rollNO) {
	Student updatedStudent =studentRepository.findById(rollNO).orElseThrow(()->new HandelExceptions("Resource Not found: "+rollNO));
	studentRepository.deleteById(rollNO);
	}
	
	
}
