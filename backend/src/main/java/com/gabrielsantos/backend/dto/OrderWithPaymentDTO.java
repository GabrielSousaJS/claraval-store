package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Order;
import lombok.Getter;
import lombok.Setter;

public class OrderWithPaymentDTO extends OrderWithoutPaymentDTO {

    @Getter @Setter
    private PaymentDTO payment;

    public OrderWithPaymentDTO() {
        super();
    }

    public OrderWithPaymentDTO(Order entity) {
        super();
        this.payment = new PaymentDTO(entity.getPayment());
    }
}