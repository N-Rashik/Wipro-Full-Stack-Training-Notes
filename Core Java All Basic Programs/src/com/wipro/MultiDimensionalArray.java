package com.wipro;

import java.util.Scanner;

public class MultiDimensionalArray {

    // Inner Student class
    static class Student {
        int id;//Declares a variable id to store the student's ID
        String name;//Declares a variable name to store the student's name.
        int[] marks;//Declares an integer array marks to store marks in multiple subjects for each student.

        // No-arg constructor
        public Student() {}//no-argument constructor,but allows to create Student objects like new Student()
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students you want to add in a Batch");
        int n = scanner.nextInt();//Reads the integer entered by the user and stores it in variable n.
        scanner.nextLine(); // consume newline

        Student[] students = new Student[n];//Creates an array students of size n to store Student objects.

        for (int i = 0; i < n; i++) {// loop to run n times to input details for each student.
            students[i] = new Student();//Initializes each student in the array using the no-arg constructor

            System.out.println("Enter student Id:");
            students[i].id = scanner.nextInt();//Reads and assigns the ID value to the current student.
            scanner.nextLine(); // consume newline

            System.out.println("Enter student name:");
            students[i].name = scanner.nextLine();//Reads the student's name as a full line 

            System.out.println("Enter no of subjects:");
            int subjectCount = scanner.nextInt();//Reads the number of subjects.
            students[i].marks = new int[subjectCount];//Initializes a new array of size subjectCount to store that student's marks.jagged array —each student can have a different number of subjects.

            System.out.println("Enter marks for " + subjectCount + " subjects");
            for (int j = 0; j < subjectCount; j++) {//Inner loop to enter each subject's marks.
                System.out.print("Subject " + (j + 1) + ": ");//Displays which subject’s mark is being entered.
                students[i].marks[j] = scanner.nextInt();//Reads the mark and stores it in the marks array.
            }
        }

        // Output
        System.out.println("\nStudents details are given below:");
        for (Student student : students) {//Enhanced for-loop (for-each) to iterate over all Student objects in the array.
            System.out.println("ID: " + student.id);
            System.out.println("Name: " + student.name);
            System.out.println("Marks:");
            for (int mark : student.marks) {//Another for-each loop to print each subject mark.
                System.out.println(mark);
            }
            System.out.println(); // blank line between students
        }

        scanner.close();
    }
}
