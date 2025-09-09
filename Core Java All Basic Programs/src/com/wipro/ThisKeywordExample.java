package com.wipro;

// Person class demonstrating various uses of 'this' keyword
class Person {

    int id;
    String name;

    // Constructor with parameters - using 'this' to differentiate variables
    public Person(int id, String name) {
        this.id = id;       // 'this' refers to current object's id
        this.name = name;   // 'this' refers to current object's name
    }

    // Default constructor - using 'this' for constructor chaining
    public Person() {
        this(101, "Niti");
    }

    // Method calling another method using 'this'
    public void showDetails() {
        System.out.println("Calling display() using this:");
        this.display(); // calling display method from the same object
    }

    // Method returning the current object
    public Person getCurrentPerson() {
        return this;
    }

    public void display() {
        System.out.println("ID: " + this.id + ", Name: " + this.name);
    }

    // Static block to show that 'this' cannot be used here
    static {
        System.out.println("Static block executed.");
        // this.id = 10; ❌ Not allowed: 'this' cannot be used in a static context
    }
}

public class ThisKeywordExample {

    public static void main(String[] args) {

        // Creating object using default constructor
        Person p1 = new Person();
        System.out.println("Using default constructor:");
        p1.display();  // Output: ID: 101, Name: Niti

        // Creating object using parameterized constructor
        Person p2 = new Person(202, "Rashik");
        System.out.println("\nUsing parameterized constructor:");
        p2.showDetails();  // Output: calls display() internally

        // Using method that returns current object
        Person returned = p2.getCurrentPerson();
        System.out.println("\nReturned object from getCurrentPerson():");
        returned.display();  // Should show same as p2
    }
}
