package com.company.customerExample;

public class Customer {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Customer(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // ToString method for printing
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
