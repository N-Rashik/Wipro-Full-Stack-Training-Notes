package com.wipro;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectionExample1 {

    // Employee class
    static class Employee {
        int id;
        String name;

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee at End");
            System.out.println("2. Display Employees");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. Search Employee by ID");
            System.out.println("5. Add Employee at Specific Position");
            System.out.println("6. Exit");
            System.out.println("7. Delete Employee at Specific Position"); // New option
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    empList.add(new Employee(id, name));
                    break;

                case 2:
                    if (empList.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee emp : empList) {
                            System.out.println("ID: " + emp.id + ", Name: " + emp.name);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean foundDelete = false;
                    for (int i = 0; i < empList.size(); i++) {
                        if (empList.get(i).id == deleteId) {
                            empList.remove(i);
                            System.out.println("Employee deleted.");
                            foundDelete = true;
                            break;
                        }
                    }
                    if (!foundDelete) {
                        System.out.println("ID not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    boolean foundSearch = false;
                    for (Employee emp : empList) {
                        if (emp.id == searchId) {
                            System.out.println("ID: " + emp.id + ", Name: " + emp.name);
                            foundSearch = true;
                            break;
                        }
                    }
                    if (!foundSearch) {
                        System.out.println("ID not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter position (starting from 0): ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    if (pos >= 0 && pos <= empList.size()) {
                        System.out.print("Enter Employee ID: ");
                        int newId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String newName = sc.nextLine();
                        empList.add(pos, new Employee(newId, newName));
                        System.out.println("Employee added at position " + pos);
                    } else {
                        System.out.println("Invalid position.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Bye!");
                    sc.close();
                    return;

                case 7:
                    System.out.print("Enter position to delete (starting from 0): ");
                    int delPos = sc.nextInt();
                    if (delPos >= 0 && delPos < empList.size()) {
                        Employee removed = empList.remove(delPos);
                        System.out.println("Deleted Employee at position " + delPos + ": ID = " + removed.id + ", Name = " + removed.name);
                    } else {
                        System.out.println("Invalid position.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
