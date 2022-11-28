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
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<GetBlacklistResponse> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createBlacklistRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateBlacklistRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(DeleteBlacklistRequest deleteBlacklistRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
