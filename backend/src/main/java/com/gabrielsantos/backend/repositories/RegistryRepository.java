package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.Registry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryRepository extends JpaRepository<Registry, Long> {
}