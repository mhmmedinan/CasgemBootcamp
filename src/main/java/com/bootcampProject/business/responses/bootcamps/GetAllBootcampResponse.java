package com.bootcampProject.business.responses.bootcamps;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBootcampResponse {

	private int id;
	private String name;
	private String instructorFirstName;
	private String instructorLastName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String bootcampStateName;
}
