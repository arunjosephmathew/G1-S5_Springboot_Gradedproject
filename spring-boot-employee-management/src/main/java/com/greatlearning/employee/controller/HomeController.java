package com.greatlearning.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return ("<h1> Welocme to the Employee Management Service</h1>"
				+ "<h2> Please Redirect to localhost:8080/swagger-ui.html </h2>");
	}

}
