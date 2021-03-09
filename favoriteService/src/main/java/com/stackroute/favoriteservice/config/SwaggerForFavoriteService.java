package com.stackroute.favoriteservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerForFavoriteService {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.stackroute"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Favorite Service API Demo By Devloper_JobPortal",
				"API realted support By DevJobPortal",
				"1.0.0",
				"Public API",
				new Contact(
						"JobPortalApp",
						"devjobportal@gmail.com",
						"www.devjobportal.com"),
				"API Liciense Open",
				"www.devjobportal.com",
				Collections.emptyList());
	}
	

}
