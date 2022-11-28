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

import com.bootcampProject.business.abstracts.BootcampStateService;
import com.bootcampProject.business.requests.bootcampStates.CreateBootcampStateRequest;
import com.bootcampProject.business.requests.bootcampStates.DeleteBootcampStateRequest;
import com.bootcampProject.business.requests.bootcampStates.UpdateBootcampStateRequest;
import com.bootcampProject.business.responses.bootcampStates.CreateBootcampStateResponse;
import com.bootcampProject.business.responses.bootcampStates.GetAllBootcampStateResponse;
import com.bootcampProject.business.responses.bootcampStates.UpdateBootcampStateResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/bootcampStates")
@AllArgsConstructor
public class BootcampStatesController {

	private BootcampStateService bootcampStateService;
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		DataResult<List<GetAllBootcampStateResponse>> result = bootcampStateService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody @Valid CreateBootcampStateRequest createBootcampStateRequest){
		DataResult<CreateBootcampStateResponse> result = bootcampStateService.add(createBootcampStateRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody @Valid  UpdateBootcampStateRequest updateBootcampStateRequest){
		DataResult<UpdateBootcampStateResponse> result = bootcampStateService.update(updateBootcampStateRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(DeleteBootcampStateRequest deleteBootcampStateRequest){
		Result result = bootcampStateService.delete(deleteBootcampStateRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
