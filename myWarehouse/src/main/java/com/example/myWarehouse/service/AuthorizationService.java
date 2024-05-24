package com.example.myWarehouse.service;

import com.example.myWarehouse.entity.AuthorizationEntity;
import com.example.myWarehouse.repository.AuthorizationRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationRepository authorizationRepository;

    public AuthorizationService(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    public AuthorizationEntity registerUser(AuthorizationEntity user) {
        return authorizationRepository.save(user);
    }

    public AuthorizationEntity entranceUser(String login, String password) {
        return authorizationRepository.findByLogin(login)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new IllegalArgumentException("Incorrect login or password"));
    }
}


