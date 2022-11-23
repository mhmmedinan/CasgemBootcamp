package com.bootcampProject.business.responses.instructors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInstructorResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String companyName;
	private String email;

}
