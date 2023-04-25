package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

public class OrderItemDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private ProductDTO product;
    @Getter @Setter
    private Integer quantity;
    @Getter @Setter
    private Double price;

    public OrderItemDTO() {
    }

    public OrderItemDTO(ProductDTO product, Integer quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemDTO(OrderItem entity) {
        product = new ProductDTO(entity.getProduct());
        quantity = entity.getQuantity();
        price = entity.getPrice();
    }
}
