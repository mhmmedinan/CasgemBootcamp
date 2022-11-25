package com.bootcampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcampProject.business.abstracts.EmployeeService;
import com.bootcampProject.business.constants.Messages;
import com.bootcampProject.business.requests.employees.CreateEmployeeRequest;
import com.bootcampProject.business.requests.employees.DeleteEmployeeRequest;
import com.bootcampProject.business.requests.employees.UpdateEmployeeRequest;
import com.bootcampProject.business.responses.employees.CreateEmployeeResponse;
import com.bootcampProject.business.responses.employees.GetAllEmployeeResponse;
import com.bootcampProject.business.responses.employees.GetEmployeeResponse;
import com.bootcampProject.business.responses.employees.UpdateEmployeeResponse;
import com.bootcampProject.core.utilities.exceptions.BusinessException;
import com.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;
import com.bootcampProject.core.utilities.results.SuccessDataResult;
import com.bootcampProject.core.utilities.results.SuccessResult;
import com.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import com.bootcampProject.entities.users.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		List<GetAllEmployeeResponse> responses = employees.stream()
				.map(employee -> modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class)).toList();
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(responses, Messages.EmployeeListed);
	}

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getByFirstName(String firstName) {
		List<Employee> employees = employeeRepository.getByFirstName(firstName);
		List<GetAllEmployeeResponse> responses = employees.stream()
				.map(employee -> modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class)).toList();
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(responses, Messages.EmployeeListed);
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		Employee employee = employeeRepository.findById(id);
		GetEmployeeResponse response = modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);
		return new SuccessDataResult<GetEmployeeResponse>(response, Messages.EmployeeListed);
	}

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		checkIfEmployeeNationalityId(createEmployeeRequest.getNationalityId());
		Employee employee = modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		employeeRepository.save(employee);

		CreateEmployeeResponse response = modelMapperService.forResponse().map(employee, CreateEmployeeResponse.class);
		return new SuccessDataResult<CreateEmployeeResponse>(response, Messages.EmployeeCreated);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfEmployeeId(updateEmployeeRequest.getId());
		Employee employee = modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		employeeRepository.save(employee);

		UpdateEmployeeResponse response = modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);
		return new SuccessDataResult<UpdateEmployeeResponse>(response, Messages.EmployeeUpdated);
	}

	@Override
	public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		checkIfEmployeeId(deleteEmployeeRequest.getId());
		Employee employee = modelMapperService.forRequest().map(deleteEmployeeRequest, Employee.class);
		employeeRepository.delete(employee);

		return new SuccessResult(Messages.EmployeeDeleted);
	}

	private void checkIfEmployeeNationalityId(String nationalityId) {
		Employee employee = employeeRepository.getByNationalityId(nationalityId);
		if (employee != null)
			throw new BusinessException(Messages.EmployeeNationalityIdExists);

	}
	
	private void checkIfEmployeeId(int id) {
		Employee employee = employeeRepository.findById(id);
		if(employee==null) throw new BusinessException(Messages.EmployeeIdNotFound);
	}

}
