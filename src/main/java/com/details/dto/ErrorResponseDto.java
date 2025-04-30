package com.details.dto;

import org.springframework.http.HttpStatusCode;

public class ErrorResponseDto {
	private String api;
	
	private HttpStatusCode code;
	
	private String errorMessage;
	
	

	public ErrorResponseDto(String api, HttpStatusCode code, String errorMessage) {
		super();
		this.api = api;
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public HttpStatusCode getCode() {
		return code;
	}

	public void setCode(HttpStatusCode code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
