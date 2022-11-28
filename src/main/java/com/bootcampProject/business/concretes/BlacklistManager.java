package com.bootcampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.BlacklistService;
import com.bootcampProject.business.constants.Messages;
import com.bootcampProject.business.requests.blacklists.CreateBlacklistRequest;
import com.bootcampProject.business.requests.blacklists.DeleteBlacklistRequest;
import com.bootcampProject.business.requests.blacklists.UpdateBlacklistRequest;
import com.bootcampProject.business.responses.blacklists.CreateBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.GetAllBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.GetBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.UpdateBlacklistResponse;
import com.bootcampProject.core.utilities.exceptions.BusinessException;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.core.utilities.results.SuccessResult;
import com.bootcampProject.dataAccess.abstracts.BlacklistRepository;
import com.bootcampProject.entities.applications.Blacklist;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {

	private BlacklistRepository blacklistRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllBlacklistResponse>> getAll() {
		List<Blacklist> blacklists = blacklistRepository.findAll();
		List<GetAllBlacklistResponse> responses = blacklists.stream()
				.map(blacklist->modelMapperService.forResponse().map(blacklist, GetAllBlacklistResponse.class)).toList();
		return new SuccessDataResult<List<GetAllBlacklistResponse>>(responses,Messages.BlacklistListed);
	}

	@Override
	public DataResult<List<GetAllBlacklistResponse>> getApplicantFirstName(String applicantFirstName) {
		List<Blacklist> blacklists = blacklistRepository.getByApplicantFirstName(applicantFirstName);
		List<GetAllBlacklistResponse> responses = blacklists.stream()
				.map(blacklist->modelMapperService.forResponse().map(blacklist, GetAllBlacklistResponse.class)).toList();
		return new SuccessDataResult<List<GetAllBlacklistResponse>>(responses,Messages.BlacklistListed);
	}

	@Override
	public DataResult<GetBlacklistResponse> getById(int id) {
		Blacklist blacklist = blacklistRepository.findById(id).get();
		GetBlacklistResponse response = modelMapperService.forResponse().map(blacklist, GetBlacklistResponse.class);
		return new SuccessDataResult<GetBlacklistResponse>(response);
	}

	@Override
	public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createBlacklistRequest) {
		checkIfApplicantIdExists(createBlacklistRequest.getApplicantId());
		Blacklist blacklist = modelMapperService.forRequest().map(createBlacklistRequest, Blacklist.class);
		blacklistRepository.save(blacklist);
		
		CreateBlacklistResponse response = modelMapperService.forResponse().map(blacklist, CreateBlacklistResponse.class);
		return new SuccessDataResult<CreateBlacklistResponse>(response,Messages.BlacklistCreated);
	}

	@Override
	public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateBlacklistRequest) {
		checkIfApplicantIdExists(updateBlacklistRequest.getApplicantId());
		Blacklist blacklist = modelMapperService.forResponse().map(updateBlacklistRequest, Blacklist.class);
		blacklistRepository.save(blacklist);
		
		UpdateBlacklistResponse response = modelMapperService.forResponse().map(blacklist, UpdateBlacklistResponse.class);
		return new SuccessDataResult<UpdateBlacklistResponse>(response,Messages.BlacklistUpdated);
	}

	@Override
	public Result delete(DeleteBlacklistRequest deleteBlacklistRequest) {
		Blacklist blacklist = modelMapperService.forRequest().map(deleteBlacklistRequest, Blacklist.class);
		blacklistRepository.delete(blacklist);
		return new SuccessResult(Messages.BlacklistDeleted);
	}

	@Override
	public DataResult<GetBlacklistResponse> getByApplicantId(int applicantId) {
		Blacklist blacklist = blacklistRepository.findByApplicantId(applicantId);
		GetBlacklistResponse response = modelMapperService.forResponse().map(blacklist, GetBlacklistResponse.class);
		return new SuccessDataResult<GetBlacklistResponse>(response);
	}
	
	private void checkIfApplicantIdExists(int applicantId) {
		Blacklist blacklist = blacklistRepository.findByApplicantId(applicantId);
		if (blacklist!=null) {
			throw new BusinessException(Messages.ApplicantIdExistsBlacklist);
		}
	}
	
	@Override
	public void checkIfBlacklistApplicantIdExists(int id) {
		if (blacklistRepository.findByApplicantId(id) != null) {
			throw new BusinessException(Messages.BlacklistApplicantIdExists);
		}
	}
	
	
}
