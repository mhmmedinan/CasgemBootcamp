package com.bootcampProject.business.requests.bootcamps;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {


	private int instructorId;
	
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate endDate;

	private int bootcampStateId;
}
