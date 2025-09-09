package com.wipro;
import java.util.Scanner;
public class OopsExample1 {
    static class Employee {
        private int id;
        private String name;
        private double salary;
        public void setId(int id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name.trim();
        }
        public void setSalary(double salary) {
            if (salary > 50000) {
                System.out.println("\nInvalid Salary: Salary should be less than or equal to 50000!");
            } else {
                this.salary = salary;
            }
        }
        public void displayInfo() {
            System.out.println("\n--- Employee Details ---");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Salary: " + salary);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();  
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        emp.displayInfo();
        sc.close();
    }
}
