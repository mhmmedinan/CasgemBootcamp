package com.bootcampProject.business.concretes;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.BootcampStateService;
import com.bootcampProject.business.constants.Messages;
import com.bootcampProject.business.requests.bootcampStates.CreateBootcampStateRequest;
import com.bootcampProject.business.requests.bootcampStates.DeleteBootcampStateRequest;
import com.bootcampProject.business.requests.bootcampStates.UpdateBootcampStateRequest;
import com.bootcampProject.business.responses.bootcampStates.CreateBootcampStateResponse;
import com.bootcampProject.business.responses.bootcampStates.GetAllBootcampStateResponse;
import com.bootcampProject.business.responses.bootcampStates.UpdateBootcampStateResponse;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.core.utilities.results.SuccessResult;
import com.bootcampProject.dataAccess.abstracts.BootcampStateRepository;
import com.bootcampProject.entities.applications.BootcampState;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootcampStateManager implements BootcampStateService {
	
	private BootcampStateRepository bootcampStateRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	@Secured("ROLE_ADMIN")
	public DataResult<List<GetAllBootcampStateResponse>> getAll() {
		List<BootcampState> bootcampStates = bootcampStateRepository.findAll();
		List<GetAllBootcampStateResponse> responses = bootcampStates.stream(
				).map(bootcampState->modelMapperService.forResponse().map(bootcampState, GetAllBootcampStateResponse.class)).toList();
		return new SuccessDataResult<List<GetAllBootcampStateResponse>>(responses,Messages.BootcampStateListed);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest createBootcampStateRequest) {
		BootcampState bootcampState = modelMapperService.forRequest().map(createBootcampStateRequest, BootcampState.class);
		bootcampStateRepository.save(bootcampState);
		
		CreateBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState,CreateBootcampStateResponse.class);
		return new SuccessDataResult<CreateBootcampStateResponse>(response,Messages.BootcampStateCreated);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest updateBootcampStateRequest) {
		BootcampState bootcampState = modelMapperService.forRequest().map(updateBootcampStateRequest, BootcampState.class);
		bootcampStateRepository.save(bootcampState);
		
		UpdateBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState, UpdateBootcampStateResponse.class);
		return new SuccessDataResult<UpdateBootcampStateResponse>(response,Messages.BootcampStateUpdated);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public Result delete(DeleteBootcampStateRequest deleteBootcampStateRequest) {
		BootcampState bootcampState = modelMapperService.forRequest().map(deleteBootcampStateRequest, BootcampState.class);
		bootcampStateRepository.delete(bootcampState);
		
		return new SuccessResult(Messages.BootcampStateDeleted);
	}

}
