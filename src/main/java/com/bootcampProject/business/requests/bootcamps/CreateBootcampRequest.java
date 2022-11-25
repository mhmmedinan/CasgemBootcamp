package com.bootcampProject.business.requests.bootcamps;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {

	private int instructorId;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private int state;
}
