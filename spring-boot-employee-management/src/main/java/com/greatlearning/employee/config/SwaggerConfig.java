package com.greatlearning.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket EmployeeApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Employee-Management-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.greatlearning.employee.controller")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employee-Management-API")
				.description("Employee Management API with Security").termsOfServiceUrl("http://ema.com")
				.contact(new Contact("Employee-Management-API", "http://ema.com", "ema@gmail.com"))
				.license("employee license").licenseUrl("http://ema.com").version("1.0").build();
	}
}