package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Order;
import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class OrderWithoutPaymentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Instant moment;
    @Getter @Setter
    private OrderStatus orderStatus;

    @Getter @Setter
    private Long clientId;

    @Getter
    private Set<OrderItemDTO> items = new HashSet<>();

    public OrderWithoutPaymentDTO() {
    }

    public OrderWithoutPaymentDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        orderStatus = entity.getOrderStatus();
        clientId = entity.getClient().getId();
    }

    public OrderWithoutPaymentDTO(Order entity, Set<OrderItem> items) {
        this(entity);
        items.forEach(item -> this.items.add(new OrderItemDTO(item)));
    }
}