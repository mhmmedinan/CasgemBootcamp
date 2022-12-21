package com.bootcampProject.webApi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcampProject.business.abstracts.RefreshTokenService;
import com.bootcampProject.business.requests.users.RefreshTokenRequest;
import com.bootcampProject.business.responses.users.RefreshTokenResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/token")
@AllArgsConstructor
public class RefreshTokensController {

	private final RefreshTokenService refreshTokenService;
	
	 @PostMapping("/refresh")
	    public RefreshTokenResponse refreshJwt(@RequestBody RefreshTokenRequest refreshTokenRequest) {
	        return refreshTokenService.refreshToken(refreshTokenRequest);
	    }
}
