package com.wipro;
import java.util.Scanner;
class Employee5 {
    int id;
    String name;
    String position;
    int salary; 
    Employee5(int id, String name, String position, int salary) {
        this.id = id;
        this.name = name.trim();
        this.position = position.trim();
        this.salary = salary;
    }
    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
    }
}
public class Activity1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee5[] employees = new Employee5[100];
        
        int count = 0;
        
        while (true) {
            System.out.println("\n1. Add\n2. View\n3. Search\n4. Update\n5. Delete\n6. Exit");
            System.out.print("Enter choice: ");
            
            int ch = sc.nextInt();
            sc.nextLine(); 
            
            if (ch == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine(); 
                
                System.out.print("Name: ");
                String name = sc.nextLine().trim();
                
                System.out.print("Position: ");
                String pos = sc.nextLine().trim();
                
                System.out.print("Salary: ");
                int sal = sc.nextInt();
                sc.nextLine(); 
                
                employees[count] = new Employee5(id, name, pos, sal);
                count++;
                System.out.println("Added.");
            }
            
            
            else if (ch == 2) {
                for (int i = 0; i < count; i++) {
                    employees[i].display();
                }
            }
            
            
            else if (ch == 3) {
                System.out.print("Enter name to search: ");
                String search = sc.nextLine().trim().toLowerCase();
                for (int i = 0; i < count; i++) {
                    String empName = employees[i].name.toLowerCase();
                    if (empName.contains(search)) {
                        employees[i].display();
                    }
                }
            }
            
            
            else if (ch == 4) {
                System.out.print("Enter ID to update: ");
                int uid = sc.nextInt();
                sc.nextLine(); 
                
                for (int i = 0; i < count; i++) {
                    if (employees[i].id == uid) {
                        System.out.print("New Name: ");
                        employees[i].name = sc.nextLine().trim();
                        
                        System.out.print("New Position: ");
                        employees[i].position = sc.nextLine().trim();
                        
                        System.out.print("New Salary: ");
                        employees[i].salary = sc.nextInt();
                        sc.nextLine(); 
                        
                        System.out.println("Updated.");
                    }
                }
            }
            
            
            else if (ch == 5) {
                System.out.print("Enter ID to delete: ");
                int did = sc.nextInt();
                sc.nextLine(); 
                for (int i = 0; i < count; i++) {
                    if (employees[i].id == did) {
                        employees[i] = employees[count - 1];
                        count--;
                        System.out.println("Deleted.");
                        break;
                    }
                }
            }
            
            
            else if (ch == 6) {
                System.out.println("Bye.");
                break;
            }
            
            
            else {
                System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}
