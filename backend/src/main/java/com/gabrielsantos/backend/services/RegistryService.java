package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.entities.Registry;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.repositories.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RegistryService {

    @Autowired
    private RegistryRepository repository;

    @Autowired
    private AuthService authService;

    public void registryAction(String action, String verbHttp) {
        User authenticated = authService.authenticated();
        Instant moment = Instant.now();
        Registry entity = new Registry(action, verbHttp, authenticated.getEmail(), moment);
        repository.save(entity);
    }
}