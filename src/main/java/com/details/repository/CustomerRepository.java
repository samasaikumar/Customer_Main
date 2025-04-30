package com.details.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.details.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Optional<Customer> findByMobileNumber(String mobileNumber);//find by method always ececutes a select query
	                                                           //we call this concept as derived named method

}
