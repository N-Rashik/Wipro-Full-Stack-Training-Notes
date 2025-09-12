package com.playstore.owner_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playstore.owner_service.client.UserServiceClient;
import com.playstore.owner_service.dto.CommentDTO;
import com.playstore.owner_service.entity.Owner;
import com.playstore.owner_service.service.OwnerService;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private OwnerService ownerService;
    private UserServiceClient userServiceClient;

    @Autowired
    public OwnerController(OwnerService ownerService,UserServiceClient userServiceClient) {
        this.ownerService = ownerService;
        this.userServiceClient=userServiceClient;
    }

    // ================= Register Page =================
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "register";
    }

    @PostMapping("/register")
    public String registerOwner(@ModelAttribute Owner owner, Model model) {
        try {
            ownerService.registerOwner(owner);
            model.addAttribute("message", "Registration successful! Please login.");
            return "login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    // ================= Login Page =================
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "login";
    }
    
//    @GetMapping("/comments/{id}")
//    public String viewComments(@PathVariable Long id, Model model) {
//        List<CommentDTO> comments = userServiceClient.getComments(id);
//        model.addAttribute("comments", comments);
//        model.addAttribute("appId", id);
//        return "comments"; 
//    }


    // ================= Dashboard =================
    @GetMapping("/dashboard")
    public String ownerDashboard(Model model) {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); 
        Owner owner = ownerService.getOwnerByEmail(email);
        model.addAttribute("owner", owner);
        model.addAttribute("apps", owner.getApps()); 
        return "dashboard";
    }
}
