package com.playstore.user_service.repository;

import com.playstore.user_service.entity.DownloadHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DownloadHistoryRepository extends JpaRepository<DownloadHistory, Long> {

    @Query("SELECT DISTINCT d.userId FROM DownloadHistory d WHERE d.appId = :appId")
    List<Long> findUserIdsByAppId(Long appId);
}
