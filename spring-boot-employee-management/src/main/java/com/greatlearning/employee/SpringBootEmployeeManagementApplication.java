package com.greatlearning.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootEmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeManagementApplication.class, args);
	}

}
