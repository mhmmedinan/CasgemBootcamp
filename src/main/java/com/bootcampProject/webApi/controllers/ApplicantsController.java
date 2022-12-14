package com.bootcampProject.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcampProject.business.abstracts.ApplicantService;
import com.bootcampProject.business.requests.applicants.CreateApplicantRequest;
import com.bootcampProject.business.requests.applicants.DeleteApplicantRequest;
import com.bootcampProject.business.requests.applicants.UpdateApplicantRequest;
import com.bootcampProject.business.responses.applicants.CreateApplicantResponse;
import com.bootcampProject.business.responses.applicants.GetAllApplicantResponse;
import com.bootcampProject.business.responses.applicants.GetApplicantResponse;
import com.bootcampProject.business.responses.applicants.UpdateApplicantResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
@CrossOrigin
public class ApplicantsController {

	private ApplicantService applicantService;

	@GetMapping("getall")
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllApplicantResponse>> result = applicantService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("getbyfirstname/{name}")
	public DataResult<List<GetAllApplicantResponse>> getByFirstName(@PathVariable String name) {
		return applicantService.getByName(name);
	}

	@GetMapping("getbyid/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
		return applicantService.getById(id);
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody CreateApplicantRequest createApplicantRequest) {
		DataResult<CreateApplicantResponse> result = applicantService.add(createApplicantRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}

		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody @Valid UpdateApplicantRequest updateApplicantRequest) {
		DataResult<UpdateApplicantResponse> result = applicantService.update(updateApplicantRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> delete(DeleteApplicantRequest deleteApplicantRequest) {
		Result result = applicantService.delete(deleteApplicantRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

}
