package com.example.Validate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Validate", "com.example.validation"})
@EnableJpaRepositories(basePackages = "com.example.validation.dao")
public class ValidationExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationExampleApplication.class, args);
    }
}
