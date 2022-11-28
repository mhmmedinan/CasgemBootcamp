package com.bootcampProject.business.responses.blacklists;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlacklistResponse {

	private int id;
	private int applicantId;
	private LocalDate date;
	private String reason;
}
