package com.example.springbootstarter.controller;

import com.example.springbootstarter.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private List<Customer> customers = createList();

    @GetMapping("/add")
    public String getCustomers() {
        return "Customer Added into the database";
    }

    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return "Customer added successfully!";
    }

    @GetMapping(value = "/getDetails", produces = "application/json")
    public List<Customer> viewAllCustomers() {
        return customers;
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                return "Customer updated successfully!";
            }
        }
        return "Customer not found!";
    }

    @DeleteMapping("/delete")
    public String deleteCustomer(@RequestParam int id) {
        customers.removeIf(c -> c.getId() == id);
        return "Customer deleted successfully!";
    }

    private static List<Customer> createList() {
        List<Customer> tempCustomers = new ArrayList<>();
        tempCustomers.add(new Customer());
        tempCustomers.add(new Customer());
        return tempCustomers;
    }
}
