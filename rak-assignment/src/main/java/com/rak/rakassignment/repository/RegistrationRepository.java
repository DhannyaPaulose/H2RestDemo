package com.rak.rakassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rak.rakassignment.domain.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
