package com.bootcampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.BootcampService;
import com.bootcampProject.business.constants.Messages;
import com.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.bootcampProject.business.requests.bootcamps.DeleteBootcampRequest;
import com.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.core.utilities.results.SuccessResult;
import com.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.bootcampProject.entities.applications.Bootcamp;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
	
	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		List<Bootcamp> bootcamps = bootcampRepository.findAll();
		List<GetAllBootcampResponse> responses = bootcamps.stream().
				map(bootcamp->modelMapperService.forResponse().map(bootcamp,GetAllBootcampResponse.class)).toList();
		return new SuccessDataResult<List<GetAllBootcampResponse>> (responses,Messages.BootcampListed);
	}

	@Override
	public DataResult<List<GetAllBootcampResponse>> getByName(String name) {
		List<Bootcamp> bootcamps = bootcampRepository.getByName(name);
		List<GetAllBootcampResponse> responses = bootcamps.stream().
				map(bootcamp->modelMapperService.forResponse().map(bootcamp,GetAllBootcampResponse.class)).toList();
		return new SuccessDataResult<List<GetAllBootcampResponse>> (responses,Messages.BootcampListed);
	}

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		Bootcamp bootcamp = bootcampRepository.findById(id).get();
		GetBootcampResponse response = modelMapperService.forResponse().map(bootcamp, GetBootcampResponse.class);
		return new SuccessDataResult<GetBootcampResponse>(response,Messages.BootcampListed);
	}

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
		Bootcamp bootcamp = modelMapperService.forRequest().map(createBootcampRequest, Bootcamp.class);
		bootcampRepository.save(bootcamp);
		
		CreateBootcampResponse response = modelMapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);
		return new SuccessDataResult<CreateBootcampResponse>(response,Messages.BootcampCreated);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
		Bootcamp bootcamp = modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
		bootcampRepository.save(bootcamp);
		
		UpdateBootcampResponse response = modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);
		return new SuccessDataResult<UpdateBootcampResponse>(response,Messages.BootcampUpdated);
	}

	@Override
	public Result delete(DeleteBootcampRequest deleteBootcampRequest) {
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setId(deleteBootcampRequest.getId());
		bootcampRepository.delete(bootcamp);
		return new SuccessResult(Messages.BootcampDeleted);
	}

	
}
