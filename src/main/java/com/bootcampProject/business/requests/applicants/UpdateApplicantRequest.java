package com.bootcampProject.business.requests.applicants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {

	private int id;
	private String firstName;
	private String lastName;
	private String about;
	private String email;
	private String password;
}