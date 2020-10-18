package com.rak.rakassignment.service;

import com.rak.rakassignment.domain.Account;

public interface AccountService {
	Account checkAccountNo(String accountNo) throws Exception;
}
