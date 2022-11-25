package com.bootcampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.ApplicationService;
import com.bootcampProject.business.constants.Messages;
import com.bootcampProject.business.requests.applications.CreateApplicationRequest;
import com.bootcampProject.business.requests.applications.DeleteApplicationRequest;
import com.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.bootcampProject.business.responses.applications.CreateApplicationResponse;
import com.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.core.utilities.results.SuccessResult;
import com.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import com.bootcampProject.entities.evaluations.Application;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {

	private ApplicationRepository applicationRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		List<Application> applications = applicationRepository.findAll();
		List<GetAllApplicationResponse> responses = applications.stream()
				.map(application -> modelMapperService.forResponse().map(application, GetAllApplicationResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllApplicationResponse>>(responses, Messages.ApplicationListed);
	}

	@Override
	public DataResult<List<GetAllApplicationResponse>> getByUserFirstName(String firstName) {
		List<Application> applications = applicationRepository.getByUserFirstName(firstName);
		List<GetAllApplicationResponse> responses = applications.stream()
				.map(application -> modelMapperService.forResponse().map(application, GetAllApplicationResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllApplicationResponse>>(responses, Messages.ApplicationListed);
	}

	@Override
	public DataResult<GetApplicationResponse> getById(int id) {
		Application application = applicationRepository.findById(id).get();
		GetApplicationResponse response = modelMapperService.forResponse().map(application, GetApplicationResponse.class);
		return new SuccessDataResult<GetApplicationResponse>(response,Messages.ApplicationListed);
	}

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
		Application application = modelMapperService.forRequest().map(createApplicationRequest, Application.class);
		applicationRepository.save(application);
		
		CreateApplicationResponse response = modelMapperService.forResponse().map(application, CreateApplicationResponse.class);
		return new SuccessDataResult<CreateApplicationResponse>(response,Messages.ApplicationCreated);
	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
		Application application = modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
		applicationRepository.save(application);
		
		UpdateApplicationResponse response = modelMapperService.forResponse().map(application, UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(response,Messages.ApplicationUpdated);
	}

	@Override
	public Result delete(DeleteApplicationRequest deleteApplicationRequest) {

		Application application = new Application();
		application.setId(deleteApplicationRequest.getId());
		applicationRepository.delete(application);
		
		return new SuccessResult(Messages.ApplicationDeleted);

	}

}
