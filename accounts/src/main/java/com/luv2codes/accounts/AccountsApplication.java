package com.luv2codes.accounts;

import com.luv2codes.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
/*@ComponentScans({ @ComponentScan("com.luv2codes.accounts.controller") })
@EnableJpaRepositories("com.luv2codes.accounts.repository")
@EntityScan("com.luv2codes.accounts.model")*/
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                description = "Luv2Bank Accounts microservice REST API Documentation",
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
                description = "Luv2Bank Accounts microservice REST API Documentation",
                url = "https://www.luv2codes.com/swagger-ui.html"
        )
)

public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
