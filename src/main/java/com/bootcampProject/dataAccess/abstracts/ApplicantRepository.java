package com.bootcampProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.users.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

	List<Applicant> getByFirstName(String firstName);
	Applicant getByNationalityId(String nationalityId);
	Applicant findById(int id);
}
