package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Order;
import com.gabrielsantos.backend.entities.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class OrderWithPaymentDTO extends OrderWithoutPaymentDTO {

    @Getter @Setter
    private PaymentDTO payment;

    public OrderWithPaymentDTO(Order entity, Set<OrderItem> items) {
        super(entity, items);
        this.payment = new PaymentDTO(entity.getPayment());
    }
}