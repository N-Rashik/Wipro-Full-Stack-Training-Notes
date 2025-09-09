package com.wipro;
class Student {//defines a class called Student.
    int id;//data member that stores students id
    String name;//data member that stores name of student
    int[] marks;//data member that stores multiple marks of single student

    // Constructor
    Student(int id, String name, int[] marks) {//constructor that gets called when a new Student object is created
        this.id = id;//Stores the input id value into object's id field
        this.name = name;//Stores the input name value into object's name field
        this.marks = marks;//Stores the input marks value into object's marks field
    }

    // Method to display student info
    void displayInfo() {//method inside student class.displays the student’s details when called
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: ");
        for (int mark : marks) {//enhanced for loop.It goes through each element (mark) in the marks array.
            System.out.println(mark + " ");
        }
     }
}

public class ArrayPractice {
    public static void main(String[] args) {
        // Creating student objects
        Student s1 = new Student(1, "rashik", new int[] {90, 48, 76});//creates a new student object s1
        Student s2 = new Student(2, "gowshik", new int[] {89, 56, 77});//creates a new student object s2

        // Displaying student info
        s1.displayInfo();//Calls the displayInfo() method on s1
        s2.displayInfo();
        
    }
}
