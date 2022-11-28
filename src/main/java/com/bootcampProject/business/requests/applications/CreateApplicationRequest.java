package com.bootcampProject.business.requests.applications;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationRequest {

	@NotNull
	private int applicantId;

	@NotNull
	private int  bootcampId;

	@NotNull
	private int applicationStateId;
}
