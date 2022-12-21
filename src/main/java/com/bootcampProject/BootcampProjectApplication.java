package com.bootcampProject;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bootcampProject.core.utilities.exceptions.BusinessException;
import com.bootcampProject.core.utilities.results.ErrorDataResult;

@SpringBootApplication
@RestControllerAdvice
@EnableGlobalMethodSecurity(securedEnabled = true)
public class BootcampProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampProjectApplication.class, args);
	}

//	@Component
//	@AllArgsConstructor
//	public class DataInitializer implements ApplicationRunner {
//
//		private EmployeeService employeeService;
//		private final PasswordEncoder passwordEncoder;
//
//		@Override
//		public void run(ApplicationArguments args) throws Exception {
//			CreateEmployeeRequest employeeRequest = new CreateEmployeeRequest();
//			employeeRequest.setFirstName("Muhammed");
//			employeeRequest.setLastName("İnan");
//			employeeRequest.setPosition("Developer");
//			employeeRequest.setDateOfBirth(LocalDate.of(1997, 9, 14));
//			employeeRequest.setEmail("admin12@test.com");
//			employeeRequest.setNationalIdentity("14543054689");
//			employeeRequest.setPassword(passwordEncoder.encode("123456"));
//			employeeRequest.setUsername("minan");
//			employeeRequest.setRole(Set.of(Role.ROLE_ADMIN));
//			employeeService.add(employeeRequest);
//
//		}
//
//	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "VALIDATION.EXCEPTION");
		return errors;

	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessExceptions(BusinessException businessException) {
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(),
				"BUSINESS.EXCEPTION");
		return errorDataResult;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<>(exception.getMessage(),
				"DATA INTEGRITY EXCEPTION");
		return errorDataResult;
	}

}
