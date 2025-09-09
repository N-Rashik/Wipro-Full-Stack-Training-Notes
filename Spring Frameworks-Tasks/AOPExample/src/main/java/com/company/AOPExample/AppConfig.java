package com.company.AOPExample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.company.AOPExample")
@EnableAspectJAutoProxy
public class AppConfig {
}
