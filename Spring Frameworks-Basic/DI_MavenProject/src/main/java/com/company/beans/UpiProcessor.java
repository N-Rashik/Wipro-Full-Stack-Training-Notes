package com.company.beans;

import org.springframework.stereotype.Component;

@Component("UpiProcessor")  // Unique name
public class UpiProcessor implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs: " + amount + " via UPI is done");
    }
}
