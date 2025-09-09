package com.wipro;

// Superclass
class Persons {
    // Common properties or methods for Person can go here
}

// Subclass representing an Employee
class Employee1 extends Persons {
    void action() {
        System.out.println("Job");
    }
}

// Subclass representing a Student
class Student1 extends Persons {
    void action() {
        System.out.println("Study");
    }
}

// Main class demonstrating instanceof keyword
public class InstanceOfExample {

    public static void main(String[] args) {

        // Polymorphism: Parent class reference refers to a child class object
        Persons p = new Student1();

        // instanceof check to avoid ClassCastException
        if (p instanceof Employee1) {
            // Safe downcasting to Employee
            Employee1 e = (Employee1) p;
            e.action(); // Will print "Job" if p was actually an Employee
        } else if (p instanceof Student1) {
            // Safe downcasting to Student
            Student1 s = (Student1) p;
            s.action(); // Will print "Study"
        } else {
            System.out.println("Unknown type");
        }
    }
}
