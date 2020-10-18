package com.rak.rakassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class RakAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RakAssignmentApplication.class, args);
	}

}
