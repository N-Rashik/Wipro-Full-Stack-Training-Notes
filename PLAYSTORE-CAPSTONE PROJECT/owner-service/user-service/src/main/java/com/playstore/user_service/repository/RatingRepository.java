package com.playstore.user_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playstore.user_service.entity.Rating;


public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByAppId(Long appId);
    Optional<Rating> findByAppIdAndUserId(Long appId, Long userId);
}
