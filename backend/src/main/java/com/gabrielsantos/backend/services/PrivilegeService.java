package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.repositories.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository repository;

    @Transactional(readOnly = true)
    public void insertClientPrivilege(User client) {
        client.getPrivileges().add(repository.findPrivilegeByAuthority("ROLE_CLIENT"));
    }
}
