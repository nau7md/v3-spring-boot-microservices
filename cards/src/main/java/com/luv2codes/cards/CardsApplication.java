package com.luv2codes.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.luv2codes.cards.controller") })
@EnableJpaRepositories("com.luv2codes.cards.repository")
@EntityScan("com.luv2codes.cards.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "Luv2Codes Cards microservice REST API Documentation",
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
				description = "Luv2Codes Cards microservice REST API Documentation",
				url = "https://www.luv2codes.com/swagger-ui.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
