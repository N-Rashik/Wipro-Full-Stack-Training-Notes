package com.example.HqlAndNativeSQL;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.HqlAndNativeSQL.Util.HibernateUtil;
import com.example.HqlAndNativeSQL.model.Employee;

public class HQLDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();

        boolean exit = false;

        while (!exit) {

            System.out.println("\nSelect operation:");
            System.out.println("1. CREATE");
            System.out.println("2. READ");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. READ ALL");
            System.out.println("6. EXIT");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) 
            
            { 
            	
            	// CREATE
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();

                Transaction tx = session.beginTransaction();
                Employee emp = new Employee(name, email);
                session.persist(emp);
                tx.commit();
                System.out.println("Employee Saved (HQL): " + emp);

            } 
            
            else if (choice == 2) 
            
            { 
            	
            	// READ
                System.out.print("Enter Employee ID to read: ");
                int empId = sc.nextInt();
                sc.nextLine();
                Employee eData = session.get(Employee.class, empId);
                if (eData != null) {
                    System.out.println("Retrieved Employee (HQL): " + eData);
                } else {
                    System.out.println("Employee not found!");
                }

            } 
            
            else if (choice == 3) 
            
            { 
            	
            	// UPDATE
                System.out.print("Enter Employee ID to update: ");
                int empId = sc.nextInt();
                sc.nextLine();
                Employee eData = session.get(Employee.class, empId);
                if (eData != null) {
                    System.out.print("Enter new email: ");
                    String email = sc.nextLine();
                    Transaction tx = session.beginTransaction();
                    eData.setEmail(email);
                    session.update(eData);
                    tx.commit();
                    System.out.println("Updated Employee (HQL): " + eData);
                } else {
                    System.out.println("Employee not found!");
                }

            } 
            
            else if (choice == 4) 
            
            { 
            	
            	// DELETE
                System.out.print("Enter Employee ID to delete: ");
                int empId = sc.nextInt();
                sc.nextLine();
                Employee eData = session.get(Employee.class, empId);
                if (eData != null) {
                    Transaction tx = session.beginTransaction();
                    session.remove(eData);
                    tx.commit();
                    System.out.println("Deleted Employee (HQL): " + eData);
                } else {
                    System.out.println("Employee not found!");
                }

            } 
            
            
            else if (choice == 5) 
            
            { 
            	// READ ALL
                Query<Employee> allQuery = session.createQuery("from Employee", Employee.class);
                List<Employee> allEmployees = allQuery.list();
                System.out.println("All Employees (HQL): " + allEmployees);

            } 
            
            
            else if (choice == 6) 
            
            { 
            	
            	// EXIT
                exit = true;
                System.out.println("Exiting program.");

            } 
            
            else 
            {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        
        session.close();
        sc.close();
    }
}
