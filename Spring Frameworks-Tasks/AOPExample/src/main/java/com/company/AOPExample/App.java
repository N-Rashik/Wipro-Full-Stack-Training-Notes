package com.company.AOPExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Checkout checkout = context.getBean(Checkout.class);

       
        checkout.checkoutOrder("Confirmed");

        System.out.println("--------------------");

        
        int result = checkout.calculation(5);
        System.out.println("Final result: " + result);

        System.out.println("--------------------");

        
        try {
            checkout.calculation(-10);
        } catch (Exception e) {
            System.out.println("Exception handled in main: " + e.getMessage());
        }
    }
}
