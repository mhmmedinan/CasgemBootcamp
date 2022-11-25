package com.bootcampProject.business.requests.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationRequest {

	private int userId;
	private int  bootcampId;
	private int state;
}
