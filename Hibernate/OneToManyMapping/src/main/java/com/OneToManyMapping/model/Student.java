package com.OneToManyMapping.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reportcard_id", referencedColumnName = "id") 
    private ReportCard reportcard;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private List<Course> courses = new ArrayList<>();

    public Student() {}
    public Student(String name) {
        this.name = name;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ReportCard getReportcard() { return reportcard; }
    public void setReportcard(ReportCard reportcard) { this.reportcard = reportcard; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    public void addCourse(Course c) {
        courses.add(c);
    }
}
