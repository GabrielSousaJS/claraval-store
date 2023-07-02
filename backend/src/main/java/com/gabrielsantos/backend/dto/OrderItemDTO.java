package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.OrderItem;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serial;
import java.io.Serializable;

public class OrderItemDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long orderId;
    @Getter @Setter
    private ProductDTO product;

    @PositiveOrZero(message = "Este valor não pode ser negativo ou igual a zero")
    @Getter @Setter
    private Integer quantity;

    @Positive(message = "Este valor não pode ser negativo ou igual a zero")
    @Getter @Setter
    private Double subTotal;

    public OrderItemDTO() {
    }

    public OrderItemDTO(OrderItem entity) {
        orderId = entity.getOrder().getId();
        product = new ProductDTO(entity.getProduct());
        quantity = entity.getQuantity();
        subTotal = entity.getSubTotal();
    }
}