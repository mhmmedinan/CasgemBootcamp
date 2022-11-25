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
	private int state;
	private String userFirstName;
	private String userLastName;
	private LocalDate userDateOfBirth;
	private String userNationalityId;
	private String userEmail;
	private String bootcampName;
	
	
}
