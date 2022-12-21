package com.bootcampProject.business.concretes;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bootcampProject.dataAccess.abstracts.UserRepository;
import com.bootcampProject.entities.users.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailManager implements UserDetailsService {

	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.isEnabled(), true, true, true, user.getAuthorities()); 
	}

}
