package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
