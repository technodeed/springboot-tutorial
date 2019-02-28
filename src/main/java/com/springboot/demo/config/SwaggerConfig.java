package com.springboot.demo.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Step20-22 - Section 3, Lecture 32, 33, 34 
 * This class is used to Document complete API details. 
 * 
 * 1. http://localhost:7070/demo/v2/api-docs  --> pull the details of all API endpoints and about this project
 * 2. http://localhost:7070/demo/swagger-ui.html#/ --> Similar thing as above but presented in HTML format.
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// Information you provided in Contact/ApiInfo class constructors, will be displayed in /v2/api-docs endpoint.
	public static final Contact DEFAULT_CONTACT = new Contact("Siddarth R Mannem", "clientair.com", "siddharthmannem@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("SpringBoot Tutorial Api Documentation", "SpringBoot Tutorial Api Documentation", "1.0", "urn:tos",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	//Step22 - Section 3, Lecture 34
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
			new HashSet<String>(Arrays.asList("application/json", "application/xml"));
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				//Step22 - Section 3, Lecture 34
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
}
