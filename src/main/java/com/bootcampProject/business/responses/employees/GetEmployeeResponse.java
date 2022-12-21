package com.bootcampProject.business.responses.employees;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

import com.bootcampProject.entities.users.Role;

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
	private LocalDate dateOfBirth;
	private String nationalIdentity;
	private String position;
	private String email;
	private String username;
	private Set<Role> role;

}
