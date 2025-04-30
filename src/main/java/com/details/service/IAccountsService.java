package com.details.service;

import com.details.dto.CustomerDto;

public interface IAccountsService {
	  void createAccount(CustomerDto customerDto);
	//  CustomerDto fetchAccountdetails(String mobileNum);
	 // boolean updateAccount(CustomerDto customerDto);
	  boolean deleteAccount(String mobileNumber);
	  

}
