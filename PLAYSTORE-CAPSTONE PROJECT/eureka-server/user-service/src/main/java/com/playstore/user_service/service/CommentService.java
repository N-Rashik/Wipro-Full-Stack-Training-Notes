package com.playstore.user_service.service;

import com.playstore.user_service.entity.Comment;
import com.playstore.user_service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) { 
        this.commentRepository = commentRepository; 
    }

 
    public Comment addComment(Comment comment) { 
        return commentRepository.save(comment); 
    }

    public List<Comment> getCommentsForApp(Long appId) { 
        return commentRepository.findByAppId(appId); 
    }

    
    public List<Comment> getCommentsByAppId(Long appId) {
        return commentRepository.findByAppId(appId);
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}
