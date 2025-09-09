package com.company.customerExample;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    private static double salary;

	public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Customer bean
        Customer customer = context.getBean(Customer.class);

        // Take input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Customer Salary: ");
        double salary = sc.nextDouble();

        // Set values using setter
        customer.setId(id);
        customer.setName(name);
        customer.setSalary(salary);

        // Print customer details
        System.out.println("\nCustomer Details:");
        System.out.println(customer);
        
        sc.close();
    }
}
