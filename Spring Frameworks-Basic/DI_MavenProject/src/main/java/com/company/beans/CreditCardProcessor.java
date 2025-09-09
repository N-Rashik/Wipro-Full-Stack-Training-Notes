package com.company.beans;

import org.springframework.stereotype.Component;

@Component("CreditCardProcessor")  // Unique name
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs: " + amount + " via Credit Card is done");
    }
}
