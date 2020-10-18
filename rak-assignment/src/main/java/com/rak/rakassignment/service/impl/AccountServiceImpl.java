package com.rak.rakassignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rak.rakassignment.domain.Account;
import com.rak.rakassignment.repository.AccountRepository;
import com.rak.rakassignment.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account checkAccountNo(String accountNo) throws Exception {

		Account account = accountRepository.checkAccountNo(accountNo);
		return account;
	}

}
