package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.entities.UserSeller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT obj FROM User obj " +
            "WHERE :name = '' OR LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<User> findAllUser(String name, Pageable pageable);

    @Query("SELECT obj FROM UserSeller obj")
    Page<UserSeller> findAllSellers(Pageable pageable);
}
