package com.bootcampProject.entities.securities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginCredential {

	private String email;
	private String password;
	
}
