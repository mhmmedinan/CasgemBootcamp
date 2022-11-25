package com.bootcampProject.webApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcampProject.business.abstracts.EmployeeService;
import com.bootcampProject.business.requests.employees.CreateEmployeeRequest;
import com.bootcampProject.business.requests.employees.DeleteEmployeeRequest;
import com.bootcampProject.business.requests.employees.UpdateEmployeeRequest;
import com.bootcampProject.business.responses.employees.CreateEmployeeResponse;
import com.bootcampProject.business.responses.employees.GetAllEmployeeResponse;
import com.bootcampProject.business.responses.employees.GetEmployeeResponse;
import com.bootcampProject.business.responses.employees.UpdateEmployeeResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {

	private EmployeeService employeeService;

	@GetMapping("getall")
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllEmployeeResponse>> result = employeeService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("getbyfirstname")
	public ResponseEntity<?> getByFirstName(String firstName){
		DataResult<List<GetAllEmployeeResponse>> result = employeeService.getByFirstName(firstName);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("getbyid")
	public ResponseEntity<?> getById(int id) {
		DataResult<GetEmployeeResponse> result = employeeService.getById(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		DataResult<CreateEmployeeResponse> result = employeeService.add(createEmployeeRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
		DataResult<UpdateEmployeeResponse> result =  employeeService.update(updateEmployeeRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		Result result = employeeService.delete(deleteEmployeeRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

}
