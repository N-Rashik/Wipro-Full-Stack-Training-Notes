package com.OneToManyMapping.model;

import jakarta.persistence.*;

@Entity
public class ReportCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int totalMarks;

    public ReportCard() {}
    public ReportCard(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTotalMarks() { return totalMarks; }
    public void setTotalMarks(int totalMarks) { this.totalMarks = totalMarks; }
}
