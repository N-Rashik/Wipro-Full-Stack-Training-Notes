package com.wipro;

import java.util.Scanner;

public class ArrayExample2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declare a jagged array
        int[][] marks = new int[3][];
        marks[0] = new int[2];  // Student 1 has 2 subjects
        marks[1] = new int[4];  // Student 2 has 4 subjects
        marks[2] = new int[6];  // Student 3 has 6 subjects

        // Input marks for each student
        System.out.println("Enter marks for each student:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print("  Subject " + (j + 1) + ": ");
                marks[i][j] = sc.nextInt();
            }
        }

        // Display the marks
        System.out.println("\n--- Displaying Student Marks ---");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println(); // next line after each student
        }

        sc.close();
    }
}
