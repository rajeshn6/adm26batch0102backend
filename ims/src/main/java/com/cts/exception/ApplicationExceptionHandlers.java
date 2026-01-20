package com.cts.exception;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.model.ApiError;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandlers {
	@ExceptionHandler(exception = InsuranceIdNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApiError handleInsuranceIdNotFoundException(InsuranceIdNotFoundException ex,
			HttpServletRequest request) {
		ApiError apiError=
				new ApiError(ex.getMessage(),ex.getClass().toString(),LocalDateTime.now(), request.getRequestURI());
		
		return apiError;
			
	}
	@ExceptionHandler(exception = org.springframework.web.bind.MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<ApiError> MethodArgumentNotValidException( org.springframework.web.bind.MethodArgumentNotValidException ex,
			HttpServletRequest request) {
		List<FieldError> listOfErrors=ex.getBindingResult().getFieldErrors();
		List<ApiError> listOfApiErrors=listOfErrors.stream().map(e-> new ApiError(e.getField()+" : "+e.getDefaultMessage(),
				ex.getClass().toString(),LocalDateTime.now(),request.getRequestURI())).collect(Collectors.toList());
		log.error("Check the data in the requestb validation failed"+ex.toString());
		return listOfApiErrors;
			
	}
	

}
