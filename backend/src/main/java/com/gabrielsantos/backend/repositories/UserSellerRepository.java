package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.UserSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserSellerRepository extends JpaRepository<UserSeller, Long> {

    @Query("SELECT obj FROM UserSeller obj " +
            "WHERE :email = obj.email")
    UserSeller findSellerByEmail(String email);

}
