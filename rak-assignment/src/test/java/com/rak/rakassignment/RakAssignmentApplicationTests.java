package com.rak.rakassignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rak.rakassignment.domain.Account;
import com.rak.rakassignment.domain.Card;
import com.rak.rakassignment.domain.Registration;
import com.rak.rakassignment.exception.ResourceNotFoundException;
import com.rak.rakassignment.repository.AccountRepository;
import com.rak.rakassignment.repository.CardRepository;
import com.rak.rakassignment.repository.RegistrationRepository;
import com.rak.rakassignment.service.CardService;

@SpringBootTest
class RakAssignmentApplicationTests {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	CardService cardService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAccount() {
		
		Account account = new Account();
		account.setAccountNo("1234567890");
		
		//save account
		accountRepository.save(account);
	
		//check if account no is present 
		accountRepository.existsById(account.getAccountNo());
		
	}
	
	@Test
	public void testCard() {
		try {
			
			Card card = new Card();
			card.setCardNo(1234567891234567L);
			card.setCardPin(1111);
			
			cardRepository.save(card);
			
		
			cardService.authCard(1234567891234567L,1234);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testRegisterUser() {
		
		try {
			
			Registration registration = new Registration();
			Registration saveRegistration = new Registration();
			
//			registration.setRegistrationId(100);
			registration.setUserName("Mary");
			registration.setPassword("poppins123");
			registration.setEmail("mary.poppins@gaga.com");
			registration.setMobile("971786543876");
			registration.setPrefCommication("email");
			registrationRepository.save(registration);
		
//			registration.setRegistrationId(101);
			registration.setUserName("Ryan");
			registration.setPassword("paul123");
			registration.setEmail("ryan.paul@hotmail.com");
			registration.setMobile("67545673456");
			registration.setPrefCommication("email");
			registrationRepository.save(registration);
			
			saveRegistration = registrationRepository.findById(1).orElseThrow(
					() -> new ResourceNotFoundException("Registered User not found by ID :: " + 100));
			
		
			saveRegistration.setPrefCommication("mobile");
			
			final Registration updatedRegistration = registrationRepository.save(registration);
			
			System.out.printf("updatedRegistration +++ ", updatedRegistration);
			
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		};
		
	}

	

}
