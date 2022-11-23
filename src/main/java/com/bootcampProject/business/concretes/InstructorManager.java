package com.bootcampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.InstructorService;
import com.bootcampProject.business.constants.Messages;
import com.bootcampProject.business.requests.instructors.CreateInstructorRequest;
import com.bootcampProject.business.requests.instructors.DeleteInstructorRequest;
import com.bootcampProject.business.requests.instructors.UpdateInstructorRequest;
import com.bootcampProject.business.responses.instructors.CreateInstructorResponse;
import com.bootcampProject.business.responses.instructors.GetAllInstructorResponse;
import com.bootcampProject.business.responses.instructors.GetInstructorResponse;
import com.bootcampProject.business.responses.instructors.UpdateInstructorResponse;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.core.utilities.results.SuccessResult;
import com.bootcampProject.dataAccess.abstracts.InstructorRepository;
import com.bootcampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

	private InstructorRepository instructorRepository;
	private ModelMapperService mapperService;

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = instructorRepository.findAll();
		List<GetAllInstructorResponse> responses = instructors.stream()
				.map(instructor -> mapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllInstructorResponse>>(responses,Messages.InstructorListed);
	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> getByFirstName(String firstName) {
		List<Instructor> instructors = instructorRepository.getByFirstName(firstName);
		List<GetAllInstructorResponse> responses = instructors.stream()
				.map(instructor -> mapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllInstructorResponse>>(responses,Messages.InstructorListed);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id)
	{
	
		Instructor instructor = instructorRepository.findById(id).get();
	
		GetInstructorResponse response = mapperService.forResponse().map(instructor, GetInstructorResponse.class);
		return new SuccessDataResult<GetInstructorResponse>(response,Messages.InstructorListed);
	}

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
		Instructor instructor = mapperService.forRequest().map(createInstructorRequest, Instructor.class);
		instructorRepository.save(instructor);
		
		CreateInstructorResponse response = mapperService.forResponse().map(instructor, CreateInstructorResponse.class);
		return new SuccessDataResult<CreateInstructorResponse>(response,Messages.InstructorCreated);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		
		Instructor instructor = mapperService.forRequest().map(updateInstructorRequest, Instructor.class);
		instructorRepository.save(instructor);
		
		UpdateInstructorResponse response = mapperService.forResponse().map(instructor, UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(response,Messages.InstructorUpdated);
	}

	@Override
	public Result delete(DeleteInstructorRequest deleteInstructorRequest){
		Instructor instructor = mapperService.forRequest().map(deleteInstructorRequest, Instructor.class);
		instructorRepository.delete(instructor);
		
		
		return new SuccessResult(Messages.InstructorDeleted);
	}

}
