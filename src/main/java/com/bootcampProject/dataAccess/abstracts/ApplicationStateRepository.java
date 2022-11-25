package com.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.evaluations.ApplicationState;

public interface ApplicationStateRepository extends JpaRepository<ApplicationState, Integer> {

}
