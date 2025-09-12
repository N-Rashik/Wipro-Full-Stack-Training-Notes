package com.playstore.user_service.repository;

import com.playstore.user_service.entity.Notification;
import com.playstore.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserAndReadStatusFalse(User user);  
    List<Notification> findByUser(User user);                  
    int countByUserIdAndReadStatusFalse(Long userId);
}
