package com.bootcampProject.business.requests.blacklists;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlacklistRequest {

	@NotNull
	private int applicantId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate date;
	
	@NotEmpty(message = "reason cannot be empty")
	private String reason;
}
