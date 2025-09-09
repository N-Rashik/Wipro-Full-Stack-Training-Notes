package com.example.validation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.model.User;
import com.example.validation.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    // Autowired the Service
    @Autowired
    private UserService userService;

    // ---------------- POST: Add User ----------------
    @PostMapping("/add")
    public ResponseEntity<String> saveUser(@Valid @RequestBody User u) {
        User uobj = userService.saveUSer(u);
        if (uobj != null)
            return ResponseEntity.ok("Data added");
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data not added");
    }

    // ---------------- GET: View All Users ----------------
    @GetMapping("/viewall")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
