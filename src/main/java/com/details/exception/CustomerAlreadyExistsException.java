package com.details.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	public CustomerAlreadyExistsException(String mgs)
	{
		super(mgs);
	}

}
