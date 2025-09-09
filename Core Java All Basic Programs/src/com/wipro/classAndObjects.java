package com.wipro;  
import java.util.Scanner;
class Employee {
    int empId = 101;
    String name = "Niti";
    int age = 35;
    String designation = "Trainer";
    // Default constructor
    Employee() {
        System.out.println(this.empId + " " + this.name + " " + this.age + " " + this.designation);
    }
    // Parameterized constructor
    Employee(int empId, String name, int age, String designation) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.designation = designation;
        System.out.println("Local values: " + empId + " " + age + " " + designation);
        System.out.println("Instance variables: " + this.empId + " " + this.age + " " + this.designation);
    }
    // Method 1
    void Input() {
        System.out.println("Input method called");
    }
    // Method 2
    void display() {
        System.out.println("Output method called");
    }
}
public class classAndObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Getting user input
        System.out.println("Enter your id:");
        int id = sc.nextInt();

        System.out.println("Enter your name:");
        String name = sc.next();

        System.out.println("Enter your age:");
        int age = sc.nextInt();

        System.out.println("Enter your designation:");
        String designation = sc.next();

        // Create an employee using user input
        Employee employee = new Employee(id, name, age, designation);

        // Call methods
        employee.Input();
        employee.display();
        
        sc.close();
    }
}
