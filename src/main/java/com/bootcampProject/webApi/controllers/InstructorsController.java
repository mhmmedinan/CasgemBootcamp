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

import com.bootcampProject.business.abstracts.InstructorService;
import com.bootcampProject.business.requests.instructors.CreateInstructorRequest;
import com.bootcampProject.business.requests.instructors.DeleteInstructorRequest;
import com.bootcampProject.business.requests.instructors.UpdateInstructorRequest;
import com.bootcampProject.business.responses.instructors.CreateInstructorResponse;
import com.bootcampProject.business.responses.instructors.GetAllInstructorResponse;
import com.bootcampProject.business.responses.instructors.GetInstructorResponse;
import com.bootcampProject.business.responses.instructors.UpdateInstructorResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorsController {

	private InstructorService instructorService;

	@GetMapping("getall")
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllInstructorResponse>> result = instructorService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("getbyname")
	public ResponseEntity<?> getByFirstName(String firstName) {
		DataResult<List<GetAllInstructorResponse>> result = instructorService.getByFirstName(firstName);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("getbyid")
	public ResponseEntity<?> getById(int id) {
		DataResult<GetInstructorResponse> result = instructorService.getById(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody CreateInstructorRequest createInstructorRequest) {
		DataResult<CreateInstructorResponse> result = instructorService.add(createInstructorRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody UpdateInstructorRequest updateInstructorRequest) {
		DataResult<UpdateInstructorResponse> result = instructorService.update(updateInstructorRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> delete(DeleteInstructorRequest deleteInstructorRequest) {
		Result result = instructorService.delete(deleteInstructorRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

}
