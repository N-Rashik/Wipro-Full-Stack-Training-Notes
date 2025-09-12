package com.playstore.owner_service.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.playstore.owner_service.entity.Owner;
import com.playstore.owner_service.repository.OwnerRepository;



@Service

public class OwnerDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private OwnerRepository ownerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Owner owner = ownerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Owner not found with email: " + email));

        return new User(
                owner.getEmail(),
                owner.getPassword(),
                Collections.emptyList() // No roles for simplicity, can add roles if needed
        );
    }
}
