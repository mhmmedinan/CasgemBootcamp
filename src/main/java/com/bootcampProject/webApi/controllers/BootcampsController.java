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

import com.bootcampProject.business.abstracts.BootcampService;
import com.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.bootcampProject.business.requests.bootcamps.DeleteBootcampRequest;
import com.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampsController {

	private BootcampService bootcampService;
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		DataResult<List<GetAllBootcampResponse>> result = bootcampService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("getbyname")
	public ResponseEntity<?> getByName(String name){
		DataResult<List<GetAllBootcampResponse>> result = bootcampService.getByName(name);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> getById(int id){
		DataResult<GetBootcampResponse> result = bootcampService.getById(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
	}
	
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody @Valid CreateBootcampRequest createBootcampRequest){
		DataResult<CreateBootcampResponse> result = bootcampService.add(createBootcampRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody @Valid UpdateBootcampRequest updateBootcampRequest){
		DataResult<UpdateBootcampResponse> result = bootcampService.update(updateBootcampRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(DeleteBootcampRequest deleteBootcampRequest){
		Result result = bootcampService.delete(deleteBootcampRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
	}
	
	
	
	
	
	
	
}
