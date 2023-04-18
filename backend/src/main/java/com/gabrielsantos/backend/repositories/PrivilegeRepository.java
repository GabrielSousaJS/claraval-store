package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findPrivilegeByAuthority(String authority);

}
