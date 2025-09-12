package com.playstore.owner_service.service;

import com.playstore.owner_service.entity.Owner;
import com.playstore.owner_service.exception.ResourceNotFoundException;
import com.playstore.owner_service.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.ownerRepository = ownerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ===================== Register Owner =====================
    public Owner registerOwner(Owner owner) {
        Optional<Owner> existingOwner = ownerRepository.findByEmail(owner.getEmail());
        if (existingOwner.isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }
        // Encrypt password
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        return ownerRepository.save(owner);
    }

    // ===================== Get Owner By Email =====================
    public Owner getOwnerByEmail(String email) {
        return ownerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with email: " + email));
    }


    // ===================== Get Owner By ID =====================
    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with ID: " + id));
    }
}
