package com.bootcampProject.business.requests.instructors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {

	private String firstName;
	private String lastName;
	private String companyName;
	private String email;
	private String password;
}
