package com.bootcampProject.business.responses.applicants;

import java.time.LocalDate;
import java.util.Set;

import com.bootcampProject.entities.users.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicantResponse {

	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String nationalIdentity;
	private String about;
	private String email;
	private String username;
	private Set<Role> role;
}
