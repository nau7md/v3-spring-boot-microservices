package com.luv2codes.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.luv2codes.loans.controller") })
@EnableJpaRepositories("com.luv2codes.loans.repository")
@EntityScan("com.luv2codes.loans.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "Luv2Bank Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Zohan Ansari",
						email = "tutor@luv2codes.com",
						url = "https://www.luv2codes.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.luv2codes.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Luv2Bank Loans microservice REST API Documentation",
				url = "https://www.luv2codes.com/swagger-ui.html"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}
