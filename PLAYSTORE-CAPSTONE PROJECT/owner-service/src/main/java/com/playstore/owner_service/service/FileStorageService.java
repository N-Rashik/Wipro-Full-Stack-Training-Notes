package com.playstore.owner_service.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageService {

    private final Path iconStorageLocation;
    private final Path appStorageLocation;

    @Autowired
    public FileStorageService() {
        this.iconStorageLocation = Paths.get("uploads/icons").toAbsolutePath().normalize();
        this.appStorageLocation = Paths.get("uploads/apps").toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.iconStorageLocation);
            Files.createDirectories(this.appStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create upload directories!", ex);
        }
    }

    public String storeIcon(MultipartFile file) {
        return storeFile(file, iconStorageLocation);
    }

    public String storeAppFile(MultipartFile file) {
        return storeFile(file, appStorageLocation);
    }

    private String storeFile(MultipartFile file, Path storageLocation) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new RuntimeException("Invalid file path: " + fileName);
            }
            Path targetLocation = storageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to store file: " + fileName, ex);
        }
    }
}
