package com.bootcampProject.business.concretes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.RefreshTokenService;
import com.bootcampProject.business.requests.users.RefreshTokenRequest;
import com.bootcampProject.business.responses.users.RefreshTokenResponse;
import com.bootcampProject.core.utilities.security.JwtUtils;
import com.bootcampProject.dataAccess.abstracts.RefreshTokenRepository;
import com.bootcampProject.entities.securities.RefreshToken;
import com.bootcampProject.entities.users.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RefreshTokenManager implements RefreshTokenService {

	private final RefreshTokenRepository refreshTokenRepository;
	private final JwtUtils jwtUtils;

	

	@Override
	public String createToken(User user) {
		var refreshToken = refreshTokenRepository.save(RefreshToken.builder().token(UUID.randomUUID().toString())
				.user(user).expiration(LocalDateTime.now(ZoneId.systemDefault()).plusMinutes(5000)).build());
		return refreshToken.getToken();
	}

	@Override
	public RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		var tokenOpt = refreshTokenRepository.findRefreshTokenByToken(refreshTokenRequest.getRefreshToken());
		if (tokenOpt==null) {
			throw new RuntimeException("Refresh Token %s not found!".formatted(refreshTokenRequest.getRefreshToken()));
		}
		var token = tokenOpt.get();
		if (isTokenExpired(token.getExpiration())) {
			refreshTokenRepository.delete(token);
			throw new RuntimeException(
					"Refresh Token %s was expired!".formatted(refreshTokenRequest.getRefreshToken()));
		}
		String jwt = jwtUtils.createJwt(token.getUser().getEmail());
		updateToken(token);
		return RefreshTokenResponse.of(jwt, token.getToken());
	}

	@Override
	public void updateToken(RefreshToken token) {
		token.setExpiration(LocalDateTime.now(ZoneId.systemDefault()).plusMinutes(5000));
		refreshTokenRepository.save(token);

	}

	@Override
	public boolean isTokenExpired(LocalDateTime expirationTime) {
		return expirationTime.isBefore(LocalDateTime.now());
	}
}
