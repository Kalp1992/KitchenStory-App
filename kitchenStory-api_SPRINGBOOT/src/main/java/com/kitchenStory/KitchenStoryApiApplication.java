package com.kitchenStory;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class KitchenStoryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchenStoryApiApplication.class, args);
		System.out.println("Kitchen Story App works!");
	}
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.kitchenStory"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"KitchenStory API",
				"Spring Boot REST API for kitchenStory.com",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Kalpana Rathod", "https://github.com/Kalp1992/", "kalpanarathod6@gmail.com"),
				"API License",
				"https://github.com/Kalp1992/",
				Collections.emptyList()
				);

}

}
