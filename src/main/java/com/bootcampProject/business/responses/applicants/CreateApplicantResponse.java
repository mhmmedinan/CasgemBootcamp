package com.bootcampProject.business.responses.applicants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String about;
	private String email;

}
