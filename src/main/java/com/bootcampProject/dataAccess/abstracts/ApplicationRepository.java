package com.bootcampProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.evaluations.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	List<Application> getByUserFirstName(String firstName);
}
