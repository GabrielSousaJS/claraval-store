package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serial;
import java.io.Serializable;

public class ProductUpdateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "The field cannot be empty or blank.")
    @Getter @Setter
    private String description;

    @Positive(message = "This value cannot be negative or equal to zero.")
    @Getter @Setter
    private Double price;

    @Positive(message = "This value cannot be negative or equal to zero.")
    @Getter @Setter
    private Integer quantity;

    public ProductUpdateDTO() {
    }

    public ProductUpdateDTO(Product entity) {
        description = entity.getDescription();
        price = entity.getPrice();
        quantity = entity.getQuantity();
    }
}
