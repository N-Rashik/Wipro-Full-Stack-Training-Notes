package com.playstore.user_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.playstore.user_service.dto.AppDTO;
import com.playstore.user_service.entity.App;
import com.playstore.user_service.feign.OwnerServiceClient;
import com.playstore.user_service.repository.AppRepository;

@Service
public class AppService {

    private final AppRepository appRepository;
    private final OwnerServiceClient ownerServiceClient;

    public AppService(AppRepository appRepository, OwnerServiceClient ownerServiceClient) {
        this.appRepository = appRepository;
        this.ownerServiceClient = ownerServiceClient;
    }

    // Convert App entity to AppDTO
    private AppDTO convertToDTO(App app) {
        AppDTO dto = new AppDTO();
        dto.setId(app.getId());
        dto.setName(app.getName());
        dto.setDescription(app.getDescription());
        dto.setVersion(app.getVersion());
        dto.setCategory(app.getCategory());
        dto.setIconUrl(app.getIconUrl());
        dto.setDownloadCount(app.getDownloadCount() != null ? app.getDownloadCount() : 0);
        dto.setDownloadUrl(app.getDownloadUrl());
        dto.setVisible(app.isVisible());
        dto.setOwnerId(app.getOwnerId());
        return dto;
    }

   
    public List<AppDTO> getAllVisibleApps() {
        List<AppDTO> localApps = appRepository.findByVisibleTrue()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        List<AppDTO> ownerApps = new ArrayList<>();
        try {
            ownerApps = ownerServiceClient.getVisibleApps();
        } catch (Exception e) {
            System.out.println("Error fetching apps from owner-service: " + e.getMessage());
        }

        localApps.addAll(ownerApps);
        return localApps;
    }

    // Search apps by keyword (local + owner-service)
    public List<AppDTO> searchApps(String keyword) {
        List<AppDTO> localApps = appRepository.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        List<AppDTO> ownerApps = new ArrayList<>();
        try {
            ownerApps = ownerServiceClient.getVisibleApps()
                    .stream()
                    .filter(app -> app.getName().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error searching apps from owner-service: " + e.getMessage());
        }

        localApps.addAll(ownerApps);
        return localApps;
    }

    public List<AppDTO> searchAppsByName(String name) {
        return searchApps(name);
    }

    // Filter apps by category (local + owner-service)
    public List<AppDTO> getAppsByCategory(String category) {
        List<AppDTO> localApps = appRepository.findByCategory(category)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        List<AppDTO> ownerApps = new ArrayList<>();
        try {
            ownerApps = ownerServiceClient.getVisibleApps()
                    .stream()
                    .filter(app -> category.equalsIgnoreCase(app.getCategory()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error fetching apps by category from owner-service: " + e.getMessage());
        }

        localApps.addAll(ownerApps);
        return localApps;
    }

    public List<AppDTO> filterByCategory(String category) {
        return getAppsByCategory(category);
    }

    public App saveApp(App app) {
        return appRepository.save(app);
    }

    public App getById(Long id) {
        return appRepository.findById(id).orElse(null);
    }
    
}
