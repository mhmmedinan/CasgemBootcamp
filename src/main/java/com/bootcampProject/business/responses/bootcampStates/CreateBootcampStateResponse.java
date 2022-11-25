package com.bootcampProject.business.responses.bootcampStates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampStateResponse {

	private int id;
	private String name;
}
