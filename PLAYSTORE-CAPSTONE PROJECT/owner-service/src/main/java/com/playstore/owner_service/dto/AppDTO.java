package com.playstore.owner_service.dto;

import org.springframework.web.multipart.MultipartFile;
import com.playstore.owner_service.entity.App;

public class AppDTO {

    private Long id;
    private String name;
    private String description;
    private String version;
    private String iconUrl;
    private String category;
    private boolean visible;
    private int downloadCount;
    private MultipartFile iconFile;
    private MultipartFile appFile;

    // Default constructor for form binding
    public AppDTO() {}

    // Constructor to create DTO from entity
    public AppDTO(App app) {
        this.id = app.getId();
        this.name = app.getName();
        this.description = app.getDescription();
        this.version = app.getVersion();
        this.iconUrl = app.getIconUrl();
        this.category = app.getCategory();
        this.visible = app.isVisible();
        this.downloadCount = app.getDownloadCount();
    }

   
    public AppDTO(Long id, String name, String description, String version, String iconUrl, String category, boolean visible) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.version = version;
        this.iconUrl = iconUrl;
        this.category = category;
        this.visible = visible;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }

    public int getDownloadCount() { return downloadCount; }
    public void setDownloadCount(int downloadCount) { this.downloadCount = downloadCount; }

    public MultipartFile getIconFile() { return iconFile; }
    public void setIconFile(MultipartFile iconFile) { this.iconFile = iconFile; }

    public MultipartFile getAppFile() { return appFile; }
    public void setAppFile(MultipartFile appFile) { this.appFile = appFile; }
}
