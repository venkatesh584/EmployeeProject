package com.venkat.student.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically increase primary key
	@Column(name = "Roll_No")
	private long rollNo;

	@Column(name = "Student_Name", nullable = false)
	private String studentName;

	@Column(name = "Branch", nullable = false)
	private String branch;

	@Column(name = "CGPA", nullable = false)
	@JsonProperty("CGPA")
	private int CGPA;

	@Column(name = "Email_Id", nullable = false, unique = true)
	private String emailId;
}
