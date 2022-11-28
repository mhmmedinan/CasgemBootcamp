package com.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.applications.Blacklist;

public interface BlacklistRepository extends JpaRepository<Blacklist, Integer> {

	Blacklist getByApplicantFirstName(String applicantFirstName);
}
