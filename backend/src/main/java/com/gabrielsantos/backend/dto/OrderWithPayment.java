package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Order;
import lombok.Getter;
import lombok.Setter;

public class OrderWithPayment extends OrderWithoutPayment {

    @Getter @Setter
    private PaymentDTO payment;

    public OrderWithPayment() {
        super();
    }

    public OrderWithPayment(Order entity) {
        super();
        this.payment = new PaymentDTO(entity.getPayment());
    }
}