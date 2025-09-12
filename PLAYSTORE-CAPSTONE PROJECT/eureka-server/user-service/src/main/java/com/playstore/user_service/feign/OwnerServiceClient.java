package com.playstore.user_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.playstore.user_service.dto.AppDTO;
import com.playstore.user_service.dto.DownloadNotificationDTO;


@FeignClient(name = "owner-service", url = "http://localhost:8081", fallback = OwnerServiceClientFallback.class)
public interface OwnerServiceClient {

    @PostMapping("/owner/notify/download")
    void notifyDownload(@RequestBody DownloadNotificationDTO dto);

    @GetMapping(value = "/api/apps/visible", produces = "application/json")
    List<AppDTO> getVisibleApps();

    @GetMapping("/owner/app")
    List<AppDTO> getAllApps();

    @GetMapping(value = "/owner/app/getApp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AppDTO getAppById(@PathVariable("id") Long id);
}



@Component
class OwnerServiceClientFallback implements OwnerServiceClient {

    @Override
    public void notifyDownload(DownloadNotificationDTO dto) {
        System.err.println("Owner service unavailable. Cannot notify download.");
    }

    @Override
    public List<AppDTO> getVisibleApps() {
        System.err.println("Owner service unavailable. Returning empty list for visible apps.");
        return List.of();
    }

    @Override
    public List<AppDTO> getAllApps() {
        System.err.println("Owner service unavailable. Returning empty list for all apps.");
        return List.of(); 
    }

    @Override
    public AppDTO getAppById(Long id) {
        System.err.println("Owner service unavailable. Returning null for app id: " + id);
        return null; 
    }
}
