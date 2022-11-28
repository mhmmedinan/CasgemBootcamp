package com.bootcampProject.business.responses.applicationStates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class GetAllApplicationStateResponse {

	private int id;
	private String name;
}
