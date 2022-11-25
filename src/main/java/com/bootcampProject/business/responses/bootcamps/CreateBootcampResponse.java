package com.bootcampProject.business.responses.bootcamps;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {

	private int id;
	private int instructorId;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private int bootcampStateId;
}
