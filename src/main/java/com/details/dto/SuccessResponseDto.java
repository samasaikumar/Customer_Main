package com.details.dto;

import org.springframework.http.HttpStatusCode;

public class SuccessResponseDto {
	
	private HttpStatusCode code;
	
	private String errorMsg;

	public HttpStatusCode getCode() {
		return code;
	}

	public void setCode(HttpStatusCode code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	

}
