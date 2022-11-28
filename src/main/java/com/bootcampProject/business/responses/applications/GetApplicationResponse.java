package com.bootcampProject.business.responses.applications;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicationResponse {

	private int id;
	private String applicationStateName;
	private String userFirstName;
	private String userLastName;
	private LocalDate userDateOfBirth;
	private String applicantNationalIdentity;
	private String userEmail;
	private String bootcampName;
}
