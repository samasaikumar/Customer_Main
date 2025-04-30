package com.details.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(name = "Accounts",
description = "Account details of SBI")
public class AccountsDto {
	
private Integer customerId;
	
    @Pattern(regexp = "^$|[0-9]{10}",message = "Invalid account number")
    @NotEmpty(message = "Account number should not be empty")
    @Schema(
    		description = "Account number of customer"
    		)
    
	private Long accountNumber;
	
    @NotEmpty(message = "Account type should not be empty")
    @Schema(description = "Account type of customer",example = "Saving")
	private String accountType;
	
    @NotEmpty(message = "Branch address should not be empty")
    @Schema(description = "Branch address",example = "valigonda")
	private String branchAddres;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddres() {
		return branchAddres;
	}

	public void setBranchAddres(String branchAddres) {
		this.branchAddres = branchAddres;
	}

	

}
