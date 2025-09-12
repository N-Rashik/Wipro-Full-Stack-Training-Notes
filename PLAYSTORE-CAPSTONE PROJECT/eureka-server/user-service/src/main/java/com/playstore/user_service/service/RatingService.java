package com.playstore.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playstore.user_service.entity.Rating;
import com.playstore.user_service.repository.RatingRepository;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public void addOrUpdateRating(Long appId, Long userId, int stars) {
        Rating rating = ratingRepository.findByAppIdAndUserId(appId, userId)
                .orElse(new Rating());
        rating.setAppId(appId);
        rating.setUserId(userId);
        rating.setStars(stars);
        ratingRepository.save(rating);
    }

    public double getAverageRating(Long appId) {
        List<Rating> ratings = ratingRepository.findByAppId(appId);
        if (ratings.isEmpty()) return 0.0;
        return ratings.stream().mapToInt(Rating::getStars).average().orElse(0.0);
    }

    public int getTotalRatings(Long appId) {
        return ratingRepository.findByAppId(appId).size();
    }
}