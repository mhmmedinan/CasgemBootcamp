package com.bootcampProject.business.abstracts;

import java.util.List;

import com.bootcampProject.business.requests.instructors.CreateInstructorRequest;
import com.bootcampProject.business.requests.instructors.DeleteInstructorRequest;
import com.bootcampProject.business.requests.instructors.UpdateInstructorRequest;
import com.bootcampProject.business.responses.instructors.CreateInstructorResponse;
import com.bootcampProject.business.responses.instructors.GetAllInstructorResponse;
import com.bootcampProject.business.responses.instructors.GetInstructorResponse;
import com.bootcampProject.business.responses.instructors.UpdateInstructorResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

public interface InstructorService {

	DataResult<List<GetAllInstructorResponse>> getAll();
	DataResult<List<GetAllInstructorResponse>> getByFirstName(String firstName);
	DataResult<GetInstructorResponse> getById(int id);
	DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);
	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
	Result delete(DeleteInstructorRequest deleteInstructorRequest);
}
