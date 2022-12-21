package com.bootcampProject.business.responses.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefreshTokenResponse {

	private String token;
	private String refreshToken;
	
	public static RefreshTokenResponse of(String token,String refreshToken) {
		return new RefreshTokenResponse(token,refreshToken );
	}
}
