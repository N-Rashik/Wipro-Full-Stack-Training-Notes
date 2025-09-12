package com.playstore.owner_service.service;

import com.playstore.owner_service.entity.Comment;
import com.playstore.owner_service.exception.ResourceNotFoundException;
import com.playstore.owner_service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsByAppId(Long appId) {
        List<Comment> comments = commentRepository.findByAppId(appId);
        if (comments.isEmpty()) {
            throw new ResourceNotFoundException("No comments found for App ID: " + appId);
        }
        return comments;
    }
}
