package com.company.AOPExample;

import org.springframework.stereotype.Component;

@Component
public class Checkout {

    public void checkoutOrder(String status) {
        System.out.println("Order process has started. Status: " + status);
    }

    public int calculation(int x) {
        int y = x + 1;
        if (x < 0) {
            throw new RuntimeException("Negative numbers not allowed!");
        }
        return y;
    }
}

