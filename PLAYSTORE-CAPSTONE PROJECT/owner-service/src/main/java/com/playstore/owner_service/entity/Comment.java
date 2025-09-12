package com.playstore.owner_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Column(length = 1000)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id")
    private App app;

    // Default constructor
    public Comment() {}

    // Parameterized constructor
    public Comment(Long id, String userName, String message, App app) {
        this.id = id;
        this.userName = userName;
        this.message = message;
        this.app = app;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public App getApp() { return app; }
    public void setApp(App app) { this.app = app; }
}
