package com.bootcampProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.applications.Bootcamp;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {

	List<Bootcamp> getByName(String name);
}
