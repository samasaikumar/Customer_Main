package com.details.exception;

public class ResourceNotFoundException  extends RuntimeException{
	
	public ResourceNotFoundException(String mgs)
	{
		super(mgs);
	}

}
