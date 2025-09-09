package com.company.customerExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Customer customer() {
        // Default bean (dummy data, will be overridden by setter if needed)
        return new Customer(0, "Default Name",0 );
    }
}
