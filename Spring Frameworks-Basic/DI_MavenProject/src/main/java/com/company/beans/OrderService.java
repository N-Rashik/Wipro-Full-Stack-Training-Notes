package com.company.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentProcessor paymentProcessor;

    @Autowired
    public OrderService(@Qualifier("UpiProcessor") PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void placeOrder(double actualAmount) {
        paymentProcessor.pay(actualAmount);
        System.out.println("Order Placed Successfully");
    }
}
