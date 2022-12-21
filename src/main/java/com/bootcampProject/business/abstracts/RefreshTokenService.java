package com.bootcampProject.business.abstracts;

import java.time.LocalDateTime;

import com.bootcampProject.business.requests.users.RefreshTokenRequest;
import com.bootcampProject.business.responses.users.RefreshTokenResponse;
import com.bootcampProject.entities.securities.RefreshToken;
import com.bootcampProject.entities.users.User;

public interface RefreshTokenService {

	 String createToken(User user);
	 RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
	 void updateToken(RefreshToken token);
	 boolean isTokenExpired(LocalDateTime expirationTime);
}
