package com.rak.rakassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rak.rakassignment.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	@Query("SELECT account FROM Account account WHERE account.accountNo = :accountNo")
	Account checkAccountNo( @Param("accountNo") String accountNo); 
	
}
