package com.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.users.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	User findByEmail(String email);
}
