package com.company.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCart cart = context.getBean(ShoppingCart.class);
        cart.checkout("checkout started");
    }
}
