package com.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")

@OpenAPIDefinition(//to display in Swagger api we use info
		info=@Info(
				title = "Accounts Microservices rest Api",
				description = "sbi accounts microservices",
				version="v1",
				contact = @Contact(
						name="Sama sai",
						email="samasaireddy2000@gmail.com"
						),
				license = @License(
						name="Apache2.0"
						)
				
				
				
				),
		externalDocs = @ExternalDocumentation(//if some external person want to know more about our app we this externalDocs
				description = "For external documentation of  sbi microservices ",
				url = "http://localhost:8080/swagger-ui/index.html#/accounts-controller/creteAccount"
				)
		
)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
