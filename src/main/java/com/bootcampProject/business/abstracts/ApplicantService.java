package com.bootcampProject.business.abstracts;

import java.util.List;

import com.bootcampProject.business.requests.applicants.CreateApplicantRequest;
import com.bootcampProject.business.requests.applicants.DeleteApplicantRequest;
import com.bootcampProject.business.requests.applicants.UpdateApplicantRequest;
import com.bootcampProject.business.responses.applicants.CreateApplicantResponse;
import com.bootcampProject.business.responses.applicants.GetAllApplicantResponse;
import com.bootcampProject.business.responses.applicants.GetApplicantResponse;
import com.bootcampProject.business.responses.applicants.UpdateApplicantResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

public interface ApplicantService {
	DataResult<List<GetAllApplicantResponse>> getAll();
	DataResult<List<GetAllApplicantResponse>> getByName(String firstName);
	DataResult<GetApplicantResponse> getById(int id);
	DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);
	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);
	Result delete(DeleteApplicantRequest deleteApplicantRequest);
}
