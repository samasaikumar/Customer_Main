package com.details.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.details.dto.ErrorResponseDto;

//cntrl+ shift+T search
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	

	
	
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
			WebRequest webRequest)
	{
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage()
				);		
		return new ResponseEntity<ErrorResponseDto> (errorResponseDto,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExsits(CustomerAlreadyExistsException customerAlreadyExistsException,
			WebRequest webRequest)
	{
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),HttpStatus.BAD_REQUEST,
				customerAlreadyExistsException.getMessage());		
		return new ResponseEntity<ErrorResponseDto> (errorResponseDto,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourecNotFoundException(ResourceNotFoundException resourceNotFoundException,
			WebRequest webRequest)
	{
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),HttpStatus.NOT_FOUND,
				resourceNotFoundException.getMessage());		
		return new ResponseEntity<ErrorResponseDto> (errorResponseDto,HttpStatus.NOT_FOUND);
		
	}
	

}
