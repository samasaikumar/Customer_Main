package com.details.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.details.constants.Constants;
import com.details.dto.AccountsDto;
import com.details.dto.CustomerDto;
import com.details.entity.Accounts;
import com.details.entity.Customer;
import com.details.exception.CustomerAlreadyExistsException;
import com.details.exception.ResourceNotFoundException;
import com.details.repository.AccountsRepository;
import com.details.repository.CustomerRepository;

@Service
public class AccountsService  implements IAccountsService{
	
	private AccountsRepository accountsRepository;
	private CustomerRepository customerRepository;
	
	



	public AccountsService(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
		super();
		this.accountsRepository = accountsRepository;
		this.customerRepository = customerRepository;
	}
	@Override
	public void createAccount(CustomerDto customerDto) {
		Optional<Customer> byMobileNumber = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
		if(byMobileNumber.isPresent())
		{
			throw new CustomerAlreadyExistsException("CustomerAlreadyExists"+customerDto.getMobileNumber());
		}
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		customerRepository.save(customer);
		Accounts newAccount = createNewAccount(customer);
		accountsRepository.save(newAccount);
		
		
		
		
	}
	//method to create new account number
	public Accounts createNewAccount(Customer customer)
	{
		Accounts accounts = new Accounts();
		accounts.setCustomerId(customer.getCustomerId());
		long randomAccNumber=1000000000+ new Random().nextLong(900000000);
		accounts.setAccountNumber(randomAccNumber);
		accounts.setAccountType(Constants.SAVING);
		accounts.setBranchAddres(Constants.ADDRESS);
		return accounts;
	
	}
//	@Override
//	public CustomerDto fetchAccountdetails(String mobileNum) {
//		Customer cusDetails = customerRepository.findByMobileNumber(mobileNum).orElseThrow(()-> new ResourceNotFoundException("no data with given mobile "
//				+ mobileNum));
//		   Accounts accDetails = accountsRepository.findByCustomerId(cusDetails.getCustomerId()).orElseThrow(()-> new ResourceNotFoundException("no data with given mobile "
//					+ mobileNum));
////		   if(accDetails != null)
////		   {
////			   System.out.println("not null mmmmmmmmmmmmmmmmmms");
////		   }
//		   CustomerDto cusDto= new CustomerDto();
//		   //cusDto.setAccounts(accDetails);
//		   if(cusDto.getAccounts()== null)
//		   {
//			   cusDto.setAccounts(new Accounts());
//		   }
//		   //Accounts accounts = cusDto.getAccounts();
//		   cusDto.getAccounts().setAccountType(accDetails.getAccountType());
//		   cusDto.getAccounts().setBranchAddres(accDetails.getBranchAddres());
//		   
//		   
//		   
//		   //BeanUtils.copyProperties(accDetails, cusDetails);
//		   
//		 //  CustomerDto dto = new CustomerDto();
//		   BeanUtils.copyProperties(cusDetails,cusDto); 
//				
//		return cusDto;
//	}
////	@Override
//	public boolean updateAccount(CustomerDto customerDto) {
//		boolean isUpdated = false;
//		AccountsDto accountsDto = customerDto.getAccountsDto();
//		if(accountsDto != null)
//		{
//			Accounts details = accountsRepository.findById(accountsDto.getAccountNumber())
//			.orElseThrow(()->new ResourceNotFoundException("No account exsists with "+accountsDto.getAccountNumber()		));
//
//		}
//		Accounts a = new Accounts();
//		if(accountsDto.getAccountNumber() != null)
//		{
//			a.setAccountNumber(accountsDto.getAccountNumber());
//			
//			
//		}
//		if(accountsDto.getAccountType() != null)
//		{
//			a.setAccountType(accountsDto.getAccountType());
//		}
//		if(accountsDto.getBranchAddres()!= null)
//		{
//			a.setBranchAddres(accountsDto.getBranchAddres());
//		}
//		
//		Accounts save = accountsRepository.save(a);
//		Integer customerId = save.getCustomerId();
//		Customer cus = customerRepository.findById(customerId)
//		.orElseThrow(()->new ResourceNotFoundException("no customer"));
//		cus.setCustomerName(customerDto.getCustomerName());
//		cus.setEmail(customerDto.getEmail());
//		customerRepository.save(cus);
//		isUpdated = true;
//		return isUpdated;
//	}
	
	
	 public boolean deleteAccount(String mobileNumber)
	{
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
		.orElseThrow(()-> new ResourceNotFoundException("No customer exists"+mobileNumber));
		accountsRepository.deleteByCustomerId(customer.getCustomerId());
		customerRepository.deleteById(customer.getCustomerId());
		return true;
		
		
	}
	
	
	

}
