package com.bootcampProject.business.responses.applicants;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetApplicantResponse {

	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String nationalityId;
	private String about;
	private String email;

}