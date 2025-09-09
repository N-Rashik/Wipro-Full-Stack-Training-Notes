package com.company.jdbcdemoexample;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.company.jdbcdemoexample1.SpringConfigFile;

import jdbctemplate.Beans.Student;
import jdbctemplate.mappers.StudentRowMapper; // ✅ Import StudentRowMapper

public class App {
    public static void main(String[] args) {
        int id = 23;
        String name = "Rashik";
        String email = "nrashik2003@gmail.com";

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfigFile.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // Insert Example
//        String insertquery = "INSERT INTO Students (id, name, email) VALUES (?, ?, ?)";
//        int rows = jdbcTemplate.update(insertquery, id, name, email);
//        System.out.println(rows + " record inserted successfully!");

        // Select Example
//        String selectquery = "SELECT * FROM Student";
//        List<Student> list = jdbcTemplate.query(selectquery, new StudentRowMapper());
//
//        for (Student obj : list)
//            System.out.println(obj);
        
//        String singleSty = "select * from student where id=?";
//
//     // Pass the id value (for example, 1) as an argument
//     Student obj = jdbcTemplate.queryForObject(
//         singleSty,
//         new Object[]{23},          // parameter values for '?'
//         new StudentRowMapper()    // your RowMapper implementation
//     );
//
//     System.out.println(obj);
        
//        String updateSql = "UPDATE student SET name = ? WHERE id = ?";
//        int rowsUpdated = jdbcTemplate.update(updateSql, "Gowshik", 23);
//
//        if (rowsUpdated > 0) {
//            System.out.println("Record updated successfully!");
//        } else {
//            System.out.println("No record found with given id.");
//        }
        
        String deleteSql = "DELETE FROM student WHERE id = ?";
        int rowsDeleted = jdbcTemplate.update(deleteSql, 23);

        if (rowsDeleted > 0) {
            System.out.println("Record deleted successfully!");
        } else {
            System.out.println("No record found with given id.");
        }




    }
}
