package com.bootcampProject.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcampProject.business.abstracts.ApplicationService;
import com.bootcampProject.business.requests.applications.CreateApplicationRequest;
import com.bootcampProject.business.requests.applications.DeleteApplicationRequest;
import com.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.bootcampProject.business.responses.applications.CreateApplicationResponse;
import com.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationsController {

	private ApplicationService applicationService;
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		DataResult<List<GetAllApplicationResponse>> result = applicationService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("getbyuserfirstname")
	public ResponseEntity<?> getByUserFirstName(String firstName){
		DataResult<List<GetAllApplicationResponse>> result = applicationService.getByUserFirstName(firstName);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	
	@GetMapping("getbyid")
	public ResponseEntity<?> getById(int id){
		DataResult<GetApplicationResponse> result = applicationService.getById(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody @Valid CreateApplicationRequest createApplicationRequest){
		DataResult<CreateApplicationResponse> result = applicationService.add(createApplicationRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody @Valid UpdateApplicationRequest updateApplicationRequest){
		DataResult<UpdateApplicationResponse> result = applicationService.update(updateApplicationRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(DeleteApplicationRequest deleteApplicationRequest){
		Result result = applicationService.delete(deleteApplicationRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	

	
}
