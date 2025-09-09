package com.OneToManyMapping;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.OneToManyMapping.model.Course;
import com.OneToManyMapping.model.ReportCard;
import com.OneToManyMapping.model.Student;
import com.OneToManyMapping.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Get student name
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();
        Student s = new Student(studentName);

        // Get report card marks
        System.out.print("Enter Total Marks: ");
        int marks = sc.nextInt();
        sc.nextLine(); // consume newline
        ReportCard rc = new ReportCard(marks);
        s.setReportcard(rc);

        // Get courses
        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Course " + i + " Name: ");
            String cname = sc.nextLine();
            s.addCourse(new Course(cname));
        }
        session.persist(rc);

     // Now save Student
     s.setReportcard(rc);
        // Save to DB
        session.persist(s);
        tx.commit();

        // Fetching student using Hibernate query
        System.out.println("\nFetching all Students with their Courses and ReportCard:");
        var query = session.createQuery("from Student", Student.class);
        for (Student st : query.list()) {
            System.out.println("Student: " + st.getName() +
                    ", Marks: " + st.getReportcard().getTotalMarks());
            for (Course c : st.getCourses()) {
                System.out.println("   Course: " + c.getCourseName());
            }
        }

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
