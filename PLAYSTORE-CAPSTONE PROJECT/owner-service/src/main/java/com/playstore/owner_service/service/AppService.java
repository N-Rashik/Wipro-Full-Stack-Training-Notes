package com.playstore.owner_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playstore.owner_service.dto.AppDTO;
import com.playstore.owner_service.entity.App;
import com.playstore.owner_service.entity.Owner;
import com.playstore.owner_service.exception.AppAlreadyExistsException;
import com.playstore.owner_service.exception.ResourceNotFoundException;
import com.playstore.owner_service.repository.AppRepository;

@Service
public class AppService {

    private AppRepository appRepository;

    @Autowired
    public AppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    // ===================== Create App =====================
    public App createApp(App app) {
        if (appRepository.findByNameAndOwnerId(app.getName(), app.getOwner().getId()).isPresent()) {
            throw new AppAlreadyExistsException("App with this name already exists");
        }
        app.setVisible(true); // Default visible
        app.setDownloadCount(0);
        return appRepository.save(app);
    }

    // ===================== Get Apps By Owner =====================
    public List<App> getAppsByOwner(Long ownerId) {
        return appRepository.findByOwnerId(ownerId);
    }
    
    public List<App> getAppsByOwner(Owner owner) {
        return getAppsByOwner(owner.getId());
    }
    
    public List<AppDTO> getAppDTOsByOwner(Owner owner) {
        return appRepository.findByOwnerId(owner.getId())
                .stream()
                .map(app -> {
                    AppDTO dto = new AppDTO(app);
                    dto.setId(app.getId());
                    dto.setName(app.getName());
                    dto.setDescription(app.getDescription());
                    dto.setVersion(app.getVersion());
                    dto.setCategory(app.getCategory());
                    dto.setIconUrl(app.getIconUrl());
                    dto.setVisible(app.isVisible());
                    dto.setDownloadCount(app.getDownloadCount());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // ===================== Get App By ID =====================
    public App getAppById(Long id) {
        return appRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("App not found with ID: " + id));
    }
    
 // AppService.java
    public List<String> getDistinctCategories() {
        return appRepository.findDistinctCategories();
    }


    // ===================== Update App =====================
 // ===================== Update App (Entity overload) =====================
    public App updateApp(App app) {
        if (app.getId() == null) {
            throw new IllegalArgumentException("App ID is required for update");
        }

        App existingApp = appRepository.findById(app.getId())
                .orElseThrow(() -> new RuntimeException("App not found with id: " + app.getId()));

        // Update only allowed fields
        existingApp.setName(app.getName());
        existingApp.setDescription(app.getDescription());
        existingApp.setVersion(app.getVersion());
        existingApp.setCategory(app.getCategory());
        existingApp.setVisible(app.isVisible());
        existingApp.setIconUrl(app.getIconUrl());
        existingApp.setAppUrl(app.getAppUrl()); // <-- include file url updates
        existingApp.setDownloadCount(app.getDownloadCount());

        return appRepository.save(existingApp);
    }
 // ===================== Update App (DTO + id overload) =====================
    public App updateApp(Long id, AppDTO appDTO) {
        App existingApp = appRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("App not found with ID: " + id));

        // Update only allowed fields
        existingApp.setName(appDTO.getName());
        existingApp.setDescription(appDTO.getDescription());
        existingApp.setVersion(appDTO.getVersion());
        existingApp.setCategory(appDTO.getCategory());
        existingApp.setVisible(appDTO.isVisible());
        existingApp.setIconUrl(appDTO.getIconUrl());
        existingApp.setDownloadCount(appDTO.getDownloadCount());

     // if a new app file is uploaded
        if (appDTO.getAppFile() != null && !appDTO.getAppFile().isEmpty()) {
         
            String fileName = appDTO.getAppFile().getOriginalFilename();
            existingApp.setAppUrl(fileName);
        }


        return appRepository.save(existingApp);
    }

     // ===================== Search Apps =====================
    public List<AppDTO> searchApps(String keyword, String category) {
        if (keyword == null) keyword = "";
        if (category == null) category = "";

        List<App> apps = appRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(keyword, category);

        return apps.stream().map(app -> {
            AppDTO dto = new AppDTO(app);
            dto.setId(app.getId());
            dto.setName(app.getName());
            dto.setDescription(app.getDescription());
            dto.setVersion(app.getVersion());
            dto.setCategory(app.getCategory());
            dto.setIconUrl(app.getIconUrl());
            dto.setVisible(app.isVisible());
            dto.setDownloadCount(app.getDownloadCount());
            return dto;
        }).collect(Collectors.toList());
    }
  
    // ===================== Delete App =====================
    public void deleteApp(Long id) {
        App app = getAppById(id);
        appRepository.delete(app);
    }

    // ===================== Toggle Visibility =====================
    public App toggleVisibility(Long id) {
        App app = getAppById(id);
        app.setVisible(!app.isVisible());
        return appRepository.save(app);
    }
    
    public List<AppDTO> getVisibleApps() {
        return appRepository.findByVisibleTrue()
                .stream()
                .map(app -> {
                    AppDTO dto = new AppDTO(app);
                    dto.setId(app.getId());
                    dto.setName(app.getName());
                    dto.setDescription(app.getDescription());
                    dto.setVersion(app.getVersion());
                    dto.setCategory(app.getCategory());
                    dto.setIconUrl(app.getIconUrl());
                    dto.setVisible(app.isVisible());
                    dto.setDownloadCount(app.getDownloadCount());
                    return dto;
                })
                .collect(Collectors.toList());
    }
    public List<App> getAllApps() {
        return appRepository.findAll();
    }
}
