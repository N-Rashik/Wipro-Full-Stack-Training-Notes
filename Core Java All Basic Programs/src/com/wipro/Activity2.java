package com.wipro;
import java.util.Scanner;

class Employee3 {
    int id;
    String name;
    String position;
    double salary;

    Employee3(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name.trim();
        this.position = position.trim();
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
    }
}

public class Activity2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee3[] employees = new Employee3[100];
        int count = 0;

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search by Name");
            System.out.println("4. Update by ID");
            System.out.println("5. Delete by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Position: ");
                    String position = sc.nextLine().trim();
                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(sc.nextLine().trim());
                    employees[count++] = new Employee3(id, name, position, salary);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.println("All Employees:");
                    for (int i = 0; i < count; i++) {
                        if (employees[i] != null) {
                            employees[i].display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine().trim();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (employees[i] != null && employees[i].name.equalsIgnoreCase(searchName)) {
                            employees[i].display();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No employee found with name: " + searchName);
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = Integer.parseInt(sc.nextLine().trim());
                    boolean updated = false;
                    for (int i = 0; i < count; i++) {
                        if (employees[i] != null && employees[i].id == updateId) {
                            System.out.print("Enter new Name: ");
                            employees[i].name = sc.nextLine().trim();
                            System.out.print("Enter new Position: ");
                            employees[i].position = sc.nextLine().trim();
                            System.out.print("Enter new Salary: ");
                            employees[i].salary = Double.parseDouble(sc.nextLine().trim());
                            System.out.println("Employee updated successfully.");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Employee with ID " + updateId + " not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine().trim());
                    boolean deleted = false;
                    for (int i = 0; i < count; i++) {
                        if (employees[i] != null && employees[i].id == deleteId) {
                            employees[i] = null;
                            System.out.println("Employee deleted successfully.");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Employee with ID " + deleteId + " not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
