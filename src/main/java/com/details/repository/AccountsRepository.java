package com.details.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.details.entity.Accounts;
import com.details.entity.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
	Optional<Accounts> findByCustomerId(Integer integer);
	
	@Transactional //at runtime if there is any error,this transactional annotation makes rolled back the changes so there will be no change
	@Modifying   //this annotation tells to spring JPa ,that this method is modifying the data
	void deleteByCustomerId(Integer id);

}
