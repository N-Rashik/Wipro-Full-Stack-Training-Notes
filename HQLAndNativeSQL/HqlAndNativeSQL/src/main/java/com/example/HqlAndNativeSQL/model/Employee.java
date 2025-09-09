package com.example.HqlAndNativeSQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  
@Table(name="employee1")  // Maps this class to "employee" table in DB
public class Employee {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;   
    
    private String name;  

    @Column(name="emailid") 
    private String email;

    // Getters and Setters
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // No-args constructor (required by Hibernate)
    public Employee() {
        super();
    }

    // Parameterized constructor
    public Employee(String name, String email) {
        super();
                this.name = name;
        this.email = email;
    }

    // toString method for printing Employee details
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}
