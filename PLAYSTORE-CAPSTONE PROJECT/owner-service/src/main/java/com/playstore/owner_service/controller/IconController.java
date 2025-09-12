package com.playstore.owner_service.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class IconController {

    private final Path ICONS_DIR = Paths.get("uploads/icons"); // folder where your icons are stored

    @GetMapping("/uploads/icons/{filename:.+}")
    public ResponseEntity<Resource> getIcon(@PathVariable String filename) throws IOException {
        Path file = ICONS_DIR.resolve(filename);
        if (!Files.exists(file)) {
            return ResponseEntity.notFound().build();
        }
        Resource resource = new UrlResource(file.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)  // or MediaType.IMAGE_JPEG if you have jpgs
                .body(resource);
    }
}
