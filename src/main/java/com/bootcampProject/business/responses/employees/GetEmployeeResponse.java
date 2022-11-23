package com.bootcampProject.business.responses.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String position;
	private String email;

}
