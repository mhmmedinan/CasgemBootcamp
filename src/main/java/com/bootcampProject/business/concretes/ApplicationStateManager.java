package com.bootcampProject.business.concretes;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.ApplicationStateService;
import com.bootcampProject.business.constants.Messages;
import com.bootcampProject.business.requests.applicationStates.CreateApplicationStateRequest;
import com.bootcampProject.business.requests.applicationStates.DeleteApplicationStateRequest;
import com.bootcampProject.business.requests.applicationStates.UpdateApplicationStateRequest;
import com.bootcampProject.business.responses.applicationStates.CreateApplicationStateResponse;
import com.bootcampProject.business.responses.applicationStates.GetAllApplicationStateResponse;
import com.bootcampProject.business.responses.applicationStates.UpdateApplicationStateResponse;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.core.utilities.results.SuccessResult;
import com.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import com.bootcampProject.entities.evaluations.ApplicationState;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationStateManager implements ApplicationStateService{
	
	private ApplicationStateRepository applicationStateRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	@Secured("ROLE_ADMIN")
	public DataResult<List<GetAllApplicationStateResponse>> getAll() {
		List<ApplicationState> applicationStates = applicationStateRepository.findAll();
		List<GetAllApplicationStateResponse> responses = applicationStates.stream()
				.map(applicationState->modelMapperService.forResponse()
						.map(applicationState, GetAllApplicationStateResponse.class)).toList();
		return new SuccessDataResult<List<GetAllApplicationStateResponse>>(responses,Messages.ApplicationStateListed);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public DataResult<CreateApplicationStateResponse> add(CreateApplicationStateRequest createApplicationStateRequest) {
		ApplicationState applicationState = modelMapperService.forRequest().map(createApplicationStateRequest, ApplicationState.class);
		applicationStateRepository.save(applicationState);
		
		CreateApplicationStateResponse response = modelMapperService.forResponse().map(applicationState, CreateApplicationStateResponse.class);
		return new SuccessDataResult<CreateApplicationStateResponse>(response,Messages.ApplicationStateCreated);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public DataResult<UpdateApplicationStateResponse> update(
			UpdateApplicationStateRequest updateApplicationStateRequest) {
		
		ApplicationState applicationState = modelMapperService.forRequest().map(updateApplicationStateRequest, ApplicationState.class);
		applicationStateRepository.save(applicationState);
		
		UpdateApplicationStateResponse  response = modelMapperService.forResponse().map(applicationState, UpdateApplicationStateResponse.class);
		return new SuccessDataResult<UpdateApplicationStateResponse>(response,Messages.ApplicationStateUpdated);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public Result delete(DeleteApplicationStateRequest deleteApplicationStateRequest) {
		ApplicationState applicationState = modelMapperService.forRequest().map(deleteApplicationStateRequest, ApplicationState.class);
		applicationStateRepository.delete(applicationState);
		return new SuccessResult(Messages.ApplicationStateDeleted);
	}

}
