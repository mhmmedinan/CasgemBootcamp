package com.bootcampProject.business.abstracts;

import java.util.List;

import com.bootcampProject.business.requests.applicationStates.CreateApplicationStateRequest;
import com.bootcampProject.business.requests.applicationStates.DeleteApplicationStateRequest;
import com.bootcampProject.business.requests.applicationStates.UpdateApplicationStateRequest;
import com.bootcampProject.business.responses.applicationStates.CreateApplicationStateResponse;
import com.bootcampProject.business.responses.applicationStates.GetAllApplicationStateResponse;
import com.bootcampProject.business.responses.applicationStates.UpdateApplicationStateResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

public interface ApplicationStateService {

	DataResult<List<GetAllApplicationStateResponse>> getAll();
	DataResult<CreateApplicationStateResponse> add(CreateApplicationStateRequest createApplicationStateRequest);
	DataResult<UpdateApplicationStateResponse> update(UpdateApplicationStateRequest updateApplicationStateRequest);
	Result delete(DeleteApplicationStateRequest deleteApplicationStateRequest);
 }
