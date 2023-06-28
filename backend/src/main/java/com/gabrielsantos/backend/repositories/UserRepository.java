package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("SELECT obj FROM User obj " +
            "WHERE :name = '' OR LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<User> findAllUser(String name);
}
