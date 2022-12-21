package com.bootcampProject.core.utilities.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import com.bootcampProject.business.concretes.UserDetailManager;

@Configuration
public class JwtTutorialSecurity {

	@Autowired
	private AuthenticationManager authenticationManager;
	private final AuthSuccessHandler authSuccessHandler;
	private final UserDetailManager userDetailManager;
	private final String secret;

	public JwtTutorialSecurity(AuthSuccessHandler authSuccessHandler, UserDetailManager userDetailManager,
			@Value("${jwt.secret}") String secret) {
		this.authSuccessHandler = authSuccessHandler;
		this.userDetailManager = userDetailManager;
		this.secret = secret;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeHttpRequests((auth) -> {
			try {
				auth	
				.anyRequest()
						.permitAll().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						.and().addFilter(authenticationFilter())
						.addFilter(new JwtAuthorizationFilter(authenticationManager, userDetailManager, secret))
						.exceptionHandling()
						.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
		JsonObjectAuthenticationFilter filter = new JsonObjectAuthenticationFilter();
		filter.setAuthenticationSuccessHandler(authSuccessHandler);
		filter.setAuthenticationManager(authenticationManager);
		return filter;
	}

}