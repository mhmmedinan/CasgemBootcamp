package com.bootcampProject.business.requests.applicationStates;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationStateRequest {

	private int id;
	
	@NotEmpty(message = "Name cannot be empty")
	private String name;
}
