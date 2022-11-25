package com.bootcampProject.business.abstracts;

import java.util.List;

import com.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.bootcampProject.business.requests.bootcamps.DeleteBootcampRequest;
import com.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

public interface BootcampService {

	DataResult<List<GetAllBootcampResponse>> getAll();

	DataResult<List<GetAllBootcampResponse>> getByName(String name);

	DataResult<GetBootcampResponse> getById(int id);

	DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest);

	DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest);

	Result delete(DeleteBootcampRequest deleteBootcampRequest);
}
