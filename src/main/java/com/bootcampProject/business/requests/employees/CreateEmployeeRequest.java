package com.bootcampProject.business.requests.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

	private String firstName;
	private String lastName;
	private String position;
	private String email;
	private String password;
}
