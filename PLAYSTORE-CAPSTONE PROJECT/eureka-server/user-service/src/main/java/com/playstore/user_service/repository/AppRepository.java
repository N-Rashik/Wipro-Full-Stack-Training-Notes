package com.playstore.user_service.repository;

import com.playstore.user_service.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {
    List<App> findByCategory(String category);
    List<App> findByNameContainingIgnoreCase(String name);
    List<App> findByVisibleTrue();
}
