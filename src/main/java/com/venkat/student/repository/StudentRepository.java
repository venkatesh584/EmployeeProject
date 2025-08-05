package com.venkat.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
