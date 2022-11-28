package com.bootcampProject.business.abstracts;

import java.util.List;

import com.bootcampProject.business.requests.blacklists.CreateBlacklistRequest;
import com.bootcampProject.business.requests.blacklists.DeleteBlacklistRequest;
import com.bootcampProject.business.requests.blacklists.UpdateBlacklistRequest;
import com.bootcampProject.business.responses.blacklists.CreateBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.GetAllBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.GetBlacklistResponse;
import com.bootcampProject.business.responses.blacklists.UpdateBlacklistResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

public interface BlacklistService {

	DataResult<List<GetAllBlacklistResponse>> getAll();
	DataResult<List<GetAllBlacklistResponse>> getApplicantFirstName(String applicantFirstName);
	DataResult<GetBlacklistResponse> getById(int id);
	DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createBlacklistRequest);
	DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateBlacklistRequest);
	Result delete(DeleteBlacklistRequest deleteBlacklistRequest);
	
}
