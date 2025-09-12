package com.playstore.owner_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Serve icons
        registry.addResourceHandler("/uploads/icons/**")
        .addResourceLocations("file:" + System.getProperty("user.dir") + "/uploads/icons/");  
        // Serve app files
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}
