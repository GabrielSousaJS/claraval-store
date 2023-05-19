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
    private ProductMinDTO product;

    @PositiveOrZero(message = "This value cannot be negative.")
    @Getter @Setter
    private Integer quantity;

    @Positive(message = "This value cannot be negative or equal to zero.")
    @Getter @Setter
    private Double subTotal;

    public OrderItemDTO() {
    }

    public OrderItemDTO(ProductMinDTO product, Integer quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = price;
    }

    public OrderItemDTO(OrderItem entity) {
        orderId = entity.getOrder().getId();
        product = new ProductMinDTO(entity.getProduct());
        quantity = entity.getQuantity();
        subTotal = entity.getSubTotal();
    }
}