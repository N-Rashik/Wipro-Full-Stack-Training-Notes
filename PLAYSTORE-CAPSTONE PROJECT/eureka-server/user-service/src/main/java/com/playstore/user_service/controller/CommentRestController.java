package com.playstore.user_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playstore.user_service.dto.CommentDTO;
import com.playstore.user_service.entity.User;
import com.playstore.user_service.service.CommentService;
import com.playstore.user_service.service.UserService;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public CommentRestController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/app/{appId}")
    public List<CommentDTO> getComments(@PathVariable Long appId) {
        return commentService.getCommentsForApp(appId).stream()
                .map(c -> {
                    String username = "Unknown";
                    if (c.getUserId() != null) {
                        var user = userService.findById(c.getUserId());
                        if(user != null) username = user.getName();
                    }
                    String createdAt = c.getCreatedAt() != null ? c.getCreatedAt().toString() : "";
                    return new CommentDTO(username, c.getMessage(), createdAt);
                })
                .collect(Collectors.toList());
    }
}
