package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemPk, Long> {
}
