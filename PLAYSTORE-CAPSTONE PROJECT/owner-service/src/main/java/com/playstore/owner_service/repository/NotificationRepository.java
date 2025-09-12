package com.playstore.owner_service.repository;

import com.playstore.owner_service.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	 List<Notification> findByOwner_IdOrderByCreatedAtDesc(Long ownerId);
    int countByOwner_IdAndReadStatusFalse(Long ownerId);


 List<Notification> findByOwner_Id(Long ownerId);


 List<Notification> findByOwner_IdAndReadStatusFalse(Long ownerId);
}
