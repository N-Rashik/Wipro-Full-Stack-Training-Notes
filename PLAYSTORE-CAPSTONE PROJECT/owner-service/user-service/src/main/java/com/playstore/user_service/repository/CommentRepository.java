package com.playstore.user_service.repository;

import com.playstore.user_service.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByAppId(Long appId);
}
