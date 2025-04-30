package com.details.dto;

import org.hibernate.validator.constraints.Length;

import com.details.entity.Accounts;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(
		name = "Customer",
		description = "schema to hold customer and accounts information"
		)
public class CustomerDto {
	
	
		
	@NotEmpty(message = "Name should not be null")
	@Size(min = 3,max = 10 ,message = "name should be between 3 to 10 characters")
	@Schema(
			description = "Name of customer ",example = "jonhs")
	private String customerName;
	
	@NotEmpty(message = "email should not be not null")
	@Email(message = "Enter valid email ")
	@Schema(description = "email of Customer",example = "johns@gmail.com")
	private String email;
	
	@Pattern(regexp = "^$|[0-9]{10}",message = "Enter valis mobile number")
	@Schema(description = "Mobile number of customer",example =" 8519951398")
	private String mobileNumber;
	
	@Schema(description = "Accounts details of customer")
	private AccountsDto accountsDto ;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AccountsDto getAccountsDto() {
		return accountsDto;
	}

	public void setAccountsDto(AccountsDto accountsDto) {
		this.accountsDto = accountsDto;
	}

	
	
	
	

}
