package com.bootcampProject.business.abstracts;

import java.util.List;

import com.bootcampProject.business.requests.applications.CreateApplicationRequest;
import com.bootcampProject.business.requests.applications.DeleteApplicationRequest;
import com.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.bootcampProject.business.responses.applications.CreateApplicationResponse;
import com.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

public interface ApplicationService {

	DataResult<List<GetAllApplicationResponse>> getAll();

	DataResult<List<GetAllApplicationResponse>> getByUserFirstName(String firstName);

	DataResult<GetApplicationResponse> getById(int id);

	DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);

	DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest);

	Result delete(DeleteApplicationRequest deleteApplicationRequest);

}
