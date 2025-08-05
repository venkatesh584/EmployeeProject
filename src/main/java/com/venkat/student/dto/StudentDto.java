package com.venkat.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	private long rollNo;
	private String studentName;
	private String branch;
	 @JsonProperty("CGPA")
	private int CGPA;
	private String emailId;
}
