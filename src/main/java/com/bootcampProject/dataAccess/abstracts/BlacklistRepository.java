package com.bootcampProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.applications.Blacklist;

public interface BlacklistRepository extends JpaRepository<Blacklist, Integer> {

	List<Blacklist> getByApplicantFirstName(String applicantFirstName);
	Blacklist findByApplicantId(int applicantId);
}
