package com.bootcampProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.users.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

	List<Instructor> getByFirstName(String firstName);
}
