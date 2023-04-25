package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Order;
import com.gabrielsantos.backend.entities.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Instant moment;
    @Getter @Setter
    private Integer orderStatus;

    @Getter @Setter
    private Long userId;
    @Getter @Setter
    private PaymentDTO payment;

    @Getter
    private Set<OrderItemDTO> items = new HashSet<>();

    public OrderDTO() {
    }

    public OrderDTO(Long id, Instant moment, Integer orderStatus, Long userId, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.payment = payment;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        orderStatus = entity.getOrderStatus().getCode();
        userId = entity.getClient().getId();
        payment = new PaymentDTO(entity.getPayment());
    }

    public OrderDTO(Order entity, Set<OrderItem> items) {
        this(entity);
        items.forEach(item -> this.items.add(new OrderItemDTO(item)));
    }
}
