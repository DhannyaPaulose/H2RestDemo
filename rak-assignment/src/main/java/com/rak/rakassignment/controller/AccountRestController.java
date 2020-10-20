package com.rak.rakassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rak.rakassignment.domain.Account;
import com.rak.rakassignment.repository.AccountRepository;
import com.rak.rakassignment.service.AccountService;

@RestController
@RequestMapping("/api/v1")
public class AccountRestController {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountService accountService;
	
	
	@PostMapping("/createaccount")
	public Account createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccountNos() {
		return accountRepository.findAll();
	}
	
	@GetMapping("/account")
	public Account getAccountByAccountId(@RequestParam(value="accountNo") String accountNo) throws Exception {
		return accountService.checkAccountNo(accountNo);
	}
	
	
	@GetMapping("/is-account/{accountNo}")
	@CrossOrigin(origins = "https://localhost:3000")
	public boolean isAccountExist(@PathVariable(value = "accountNo") String accountNo) throws Exception {
		return accountRepository.existsById(accountNo);
	}
}
