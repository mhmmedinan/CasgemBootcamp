package com.bootcampProject.business.requests.instructors;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String nationalityId;
	private String companyName;
	private String email;
	private String password;
}
