package com.bootcampProject.business.requests.applicants;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {

	private int id;

	@NotEmpty(message = "FirstName cannot be empty")
	private String firstName;
	
	@NotEmpty(message = "LastName cannot be empty")
	private String lastName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
	
	@Size(min = 11,max =11,message = "NationalityId must be no more than 11 digits")
	private String nationalIdentity;
	
	@NotEmpty(message = "About cannot be empty")
	private String about;
	
	@NotEmpty(message = "Email cannot be empty")
	@Email(message="Email format is incorrect")
	private String email;
	
	@NotEmpty(message = "Password cannot be empty")
	@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
	message = "Password must be minimum 8 characters, at least one letter, one number and one special character:")
	private String password;
}
