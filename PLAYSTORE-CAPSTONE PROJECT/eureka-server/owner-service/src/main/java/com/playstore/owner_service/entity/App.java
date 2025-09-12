package com.playstore.owner_service.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "apps")
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    private String version;

    @Column(name="icon_url")
     private String iconUrl;

    private String category;

    private boolean visible = true;

    private int downloadCount = 0;
    
    private String appUrl;  // for APK/ZIP


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "app", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    // Default constructor
    public App() {}

    // Parameterized constructor
    public App(Long id, String name, String description, String version, String iconUrl, String category,
               boolean visible, int downloadCount, Owner owner, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.version = version;
        this.iconUrl = iconUrl;
        this.category = category;
        this.visible = visible;
        this.downloadCount = downloadCount;
        this.owner = owner;
        this.comments = comments;
        
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getAppUrl() { return appUrl; }
    public void setAppUrl(String appUrl) { this.appUrl = appUrl; }


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

    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}
