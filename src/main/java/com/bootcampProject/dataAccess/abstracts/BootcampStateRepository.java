package com.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.applications.BootcampState;

public interface BootcampStateRepository extends JpaRepository<BootcampState,Integer>{

}
