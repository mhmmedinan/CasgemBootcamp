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

import com.bootcampProject.business.abstracts.BlacklistService;
import com.bootcampProject.business.requests.blacklists.CreateBlacklistRequest;
import com.bootcampProject.business.requests.blacklists.DeleteBlacklistRequest;
import com.bootcampProject.business.requests.blacklists.UpdateBlacklistRequest;
import com.bootcampProject.business.responses.blacklists.CreateBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.GetAllBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.GetBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.UpdateBlacklistResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlacklistsController {

	private BlacklistService blacklistService;
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		DataResult<List<GetAllBlacklistResponse>> result = blacklistService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("getByApplicantFirstName")
	public ResponseEntity<?> getByApplicantFirstName(String applicantFirstName){
		DataResult<List<GetAllBlacklistResponse>> result = blacklistService.getApplicantFirstName(applicantFirstName);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<?> getById(int id){
		DataResult<GetBlacklistResponse> result = blacklistService.getById(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody CreateBlacklistRequest createBlacklistRequest){
		DataResult<CreateBlacklistResponse> result = blacklistService.add(createBlacklistRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody UpdateBlacklistRequest updateBlacklistRequest){
		DataResult<UpdateBlacklistResponse> result = blacklistService.update(updateBlacklistRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(DeleteBlacklistRequest deleteBlacklistRequest){
		Result result = blacklistService.delete(deleteBlacklistRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	
	
	
	
	
	
	
	
}
