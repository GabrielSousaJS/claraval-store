package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
