package com.playstore.owner_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.playstore.owner_service.dto.AppDTO;
import com.playstore.owner_service.dto.CommentDTO;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    // Get all visible apps for users
    @GetMapping("/user/apps")
    List<AppDTO> getVisibleApps();

    // Get apps filtered by category
    @GetMapping("/user/apps/category/{category}")
    List<AppDTO> getAppsByCategory(@PathVariable String category);
    
    @GetMapping(value = "/user/api/comments/app/{appId}", produces = "application/json")
    List<CommentDTO> getComments(@PathVariable("appId") Long appId);
    
    @GetMapping("/owner/apps/{id}")
    AppDTO getAppById(@PathVariable("id") Long id);

   
}
