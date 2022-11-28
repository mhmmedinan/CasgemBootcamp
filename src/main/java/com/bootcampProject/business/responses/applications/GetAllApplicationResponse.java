package com.bootcampProject.business.responses.applications;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllApplicationResponse {

	private int id;
	private String applicationStateName;
	private String applicantFirstName;
	private String applicantLastName;
	private LocalDate applicantDateOfBirth;
	private String applicantNationalIdentity;
	private String applicantEmail;
	private String bootcampName;

}
