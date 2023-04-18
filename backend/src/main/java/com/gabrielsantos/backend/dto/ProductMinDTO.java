package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serial;
import java.io.Serializable;

public class ProductMinDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long id;

    @NotBlank(message = "The field cannot be empty or blank.")
    @Getter @Setter
    private String name;

    @Positive(message = "This value cannot be negative or equal to zero.")
    @Getter @Setter
    private Double price;

    @NotNull(message = "This field cannot be null.")
    @Getter @Setter
    private String imgUrl;

    public ProductMinDTO() {
    }

    public ProductMinDTO(Long id, String name, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }
}
