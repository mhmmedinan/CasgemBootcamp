package com.bootcampProject.business.responses.blacklists;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBlacklistResponse {

	private int id;
	private String applicantFirstName;
	private String applicantLastName;
	private LocalDate date;
	private String reason;
}
