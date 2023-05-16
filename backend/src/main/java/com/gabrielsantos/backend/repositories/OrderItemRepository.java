package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

    @Query("SELECT obj FROM OrderItem obj WHERE obj.id.order.id = :orderId")
    List<OrderItem> findAllItemsOfOrder(Long orderId);

}
