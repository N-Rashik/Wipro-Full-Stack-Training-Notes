package com.playstore.owner_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.playstore.owner_service.entity.App;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {

    // Find all apps by owner
    List<App> findByOwnerId(Long ownerId);

    // Find by name & owner to prevent duplicate app
    Optional<App> findByNameAndOwnerId(String name, Long ownerId);

    // Find all visible apps for users
    List<App> findByVisibleTrue();

    // Find by category
    List<App> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);
    

    @Query("SELECT DISTINCT a.category FROM App a")
    List<String> findDistinctCategories();

}
