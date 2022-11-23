package com.bootcampProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcampProject.entities.users.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	List<Employee> getByFirstName(String firstName);
}
