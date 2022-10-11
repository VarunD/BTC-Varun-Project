package com.btc.car;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class CarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		 
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiDetails())        
				.select()//
				.paths(PathSelectors.ant("/cars/**"))//apart from cars we can add something
				//.paths(PathSelectors.any())
				.build();//to build a docket we use the docket builder....

	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Car Management System", //Title
				"Api to access the details of Cars", 
				"1.0", 								 //version
				"free to use",						
				new springfox.documentation.service.Contact("Varun", "https://gitlab.com/Varun_D/four-project.git",
						"varundacharya34@gmail.com"), 
				"Api License", //license 
				"https://gitlab.com/Varun_D/four-project.git", 
				Collections.emptyList()); 
	}
}
