package com.bootcampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.ApplicantService;
import com.bootcampProject.business.constants.Messages;
import com.bootcampProject.business.requests.applicants.CreateApplicantRequest;
import com.bootcampProject.business.requests.applicants.DeleteApplicantRequest;
import com.bootcampProject.business.requests.applicants.UpdateApplicantRequest;
import com.bootcampProject.business.responses.applicants.CreateApplicantResponse;
import com.bootcampProject.business.responses.applicants.GetAllApplicantResponse;
import com.bootcampProject.business.responses.applicants.GetApplicantResponse;
import com.bootcampProject.business.responses.applicants.UpdateApplicantResponse;
import com.bootcampProject.core.utilities.exceptions.BusinessException;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.core.utilities.results.SuccessResult;
import com.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import com.bootcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {

		List<Applicant> applicants = applicantRepository.findAll();
		List<GetAllApplicantResponse> responses = applicants.stream()
				.map(applicant -> modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllApplicantResponse>>(responses, Messages.ApplicantListed);

	}

	@Override
	public DataResult<List<GetAllApplicantResponse>> getByName(String firstName) {
		List<Applicant> applicants = applicantRepository.getByFirstName(firstName);
		List<GetAllApplicantResponse> responses = applicants.stream()
				.map(applicant -> modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllApplicantResponse>>(responses, Messages.ApplicantListed);
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {

		Applicant applicant = applicantRepository.findById(id);
		GetApplicantResponse response = modelMapperService.forResponse().map(applicant, GetApplicantResponse.class);
		return new SuccessDataResult<GetApplicantResponse>(response, Messages.ApplicantListed);
	}

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		checkIfApplicantNationalityId(createApplicantRequest.getNationalityId());
		Applicant applicant = modelMapperService.forRequest().map(createApplicantRequest, Applicant.class);
		applicantRepository.save(applicant);

		CreateApplicantResponse response = modelMapperService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(response, Messages.ApplicantCreated);
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
		checkIfApplicantId(updateApplicantRequest.getId());
		Applicant applicant = modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
		applicantRepository.save(applicant);

		UpdateApplicantResponse response = modelMapperService.forResponse().map(applicant,
				UpdateApplicantResponse.class);
		return new SuccessDataResult<UpdateApplicantResponse>(response, Messages.ApplicantUpdated);
	}

	@Override
	public Result delete(DeleteApplicantRequest deleteApplicantRequest) {
		checkIfApplicantId(deleteApplicantRequest.getId());
		Applicant applicant = modelMapperService.forRequest().map(deleteApplicantRequest, Applicant.class);
		applicantRepository.delete(applicant);

		return new SuccessResult(Messages.ApplicantDeleted);
	}

	private void checkIfApplicantNationalityId(String nationalityId) {
		Applicant applicant = applicantRepository.getByNationalityId(nationalityId);
		if (applicant != null)
			throw new BusinessException(Messages.ApplicantNationalityIdExists);

	}
	
	private void checkIfApplicantId(int id) {
		Applicant applicant = applicantRepository.findById(id);
		System.out.println(applicant);
		if (applicant==null) throw new BusinessException(Messages.ApplicantIdNotFound);
			
	}

}
