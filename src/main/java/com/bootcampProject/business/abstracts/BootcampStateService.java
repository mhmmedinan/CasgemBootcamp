package com.bootcampProject.business.abstracts;

import java.util.List;

import com.bootcampProject.business.requests.bootcampStates.CreateBootcampStateRequest;
import com.bootcampProject.business.requests.bootcampStates.DeleteBootcampStateRequest;
import com.bootcampProject.business.requests.bootcampStates.UpdateBootcampStateRequest;
import com.bootcampProject.business.responses.bootcampStates.CreateBootcampStateResponse;
import com.bootcampProject.business.responses.bootcampStates.GetAllBootcampStateResponse;
import com.bootcampProject.business.responses.bootcampStates.UpdateBootcampStateResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

public interface BootcampStateService {

	DataResult<List<GetAllBootcampStateResponse>> getAll();
	DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest createBootcampStateRequest);
	DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest updateBootcampStateRequest);
	Result delete(DeleteBootcampStateRequest deleteBootcampStateRequest);
}
