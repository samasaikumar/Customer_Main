package com.details.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Accounts extends Audit_Details{
	
	private Integer customerId;
	
	@Id
	private Long accountNumber;
	
	private String accountType;
	
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
