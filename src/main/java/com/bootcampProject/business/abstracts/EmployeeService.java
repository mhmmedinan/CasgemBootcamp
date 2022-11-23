package com.bootcampProject.business.abstracts;

import java.util.List;

import com.bootcampProject.business.requests.employees.CreateEmployeeRequest;
import com.bootcampProject.business.requests.employees.DeleteEmployeeRequest;
import com.bootcampProject.business.requests.employees.UpdateEmployeeRequest;
import com.bootcampProject.business.responses.employees.CreateEmployeeResponse;
import com.bootcampProject.business.responses.employees.GetAllEmployeeResponse;
import com.bootcampProject.business.responses.employees.GetEmployeeResponse;
import com.bootcampProject.business.responses.employees.UpdateEmployeeResponse;
import com.bootcampProject.core.utilities.results.DataResult;
import com.bootcampProject.core.utilities.results.Result;

public interface EmployeeService {

	DataResult<List<GetAllEmployeeResponse>> getAll();

	DataResult<List<GetAllEmployeeResponse>> getByFirstName(String firstName);

	DataResult<GetEmployeeResponse> getById(int id);

	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);

	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);

	Result delete(DeleteEmployeeRequest deleteEmployeeRequest);
}
