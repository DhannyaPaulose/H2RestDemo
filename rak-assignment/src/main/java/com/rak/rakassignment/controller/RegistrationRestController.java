package com.rak.rakassignment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rak.rakassignment.domain.Registration;
import com.rak.rakassignment.exception.ResourceNotFoundException;
import com.rak.rakassignment.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/v1")
public class RegistrationRestController {

	@Autowired
	RegistrationRepository registrationRepository;

	@PostMapping("/registeredUser")
	public Registration createRegistrationUser(@RequestBody Registration registration) {
		return registrationRepository.save(registration);
	}

	@GetMapping("/registeredUsers")
	public List<Registration> getAllRegisteredUsers() {
		return registrationRepository.findAll();
	}

	@GetMapping("/registeredUser/{regId}")
	public Optional<Registration> getRegisteredUser(@PathVariable(name = "regId") int registrationId) {
		return registrationRepository.findById(registrationId);
	}

	@PutMapping("/registeredUser/{regId}")
	public ResponseEntity<Registration> updateRegisteredUser(@PathVariable(value = "regId") int registrationId,
			@RequestBody Registration registrationDetails) throws ResourceNotFoundException {

		Registration registration = registrationRepository.findById(registrationId).orElseThrow(
				() -> new ResourceNotFoundException("Registered User not found by ID :: " + registrationId));
		
		registration.setUserName(registrationDetails.getUserName());
		registration.setPassword(registrationDetails.getPassword());
		registration.setEmail(registrationDetails.getEmail());
		registration.setMobile(registrationDetails.getMobile());
		registration.setPrefCommication(registrationDetails.getPrefCommication());
		
		final Registration updatedRegistration = registrationRepository.save(registration);
		return ResponseEntity.ok(updatedRegistration);
	
	}
	
	@DeleteMapping("/registeredUser/{regId}")
    public Map< String, Boolean > deleteRegisteredUser(@PathVariable(value = "regId") int registrationId)
    throws ResourceNotFoundException {
        Registration registration = registrationRepository.findById(registrationId)
            .orElseThrow(() -> new ResourceNotFoundException("Registered User not found by ID :: " + registrationId));

        registrationRepository.delete(registration);
        Map < String, Boolean > response = new HashMap< > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
