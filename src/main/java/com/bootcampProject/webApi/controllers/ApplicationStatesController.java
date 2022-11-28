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

import com.bootcampProject.business.abstracts.ApplicationStateService;
import com.bootcampProject.business.requests.applicationStates.CreateApplicationStateRequest;
import com.bootcampProject.business.requests.applicationStates.DeleteApplicationStateRequest;
import com.bootcampProject.business.requests.applicationStates.UpdateApplicationStateRequest;
import com.bootcampProject.business.responses.applicationStates.CreateApplicationStateResponse;
import com.bootcampProject.business.responses.applicationStates.GetAllApplicationStateResponse;
import com.bootcampProject.business.responses.applicationStates.UpdateApplicationStateResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applicationStates")
@AllArgsConstructor
public class ApplicationStatesController {

	private ApplicationStateService applicationStateService;

	@GetMapping("getall")
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllApplicationStateResponse>> result = applicationStateService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody @Valid CreateApplicationStateRequest createApplicationStateRequest) {
		DataResult<CreateApplicationStateResponse> result = applicationStateService.add(createApplicationStateRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody @Valid UpdateApplicationStateRequest updateApplicationStateRequest){
		DataResult<UpdateApplicationStateResponse> result = applicationStateService.update(updateApplicationStateRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(DeleteApplicationStateRequest deleteApplicationStateRequest){
		Result result = applicationStateService.delete(deleteApplicationStateRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

}
