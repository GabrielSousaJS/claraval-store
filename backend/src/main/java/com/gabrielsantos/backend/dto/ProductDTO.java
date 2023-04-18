package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Category;
import com.gabrielsantos.backend.entities.Product;
import com.gabrielsantos.backend.entities.UserSeller;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long id;

    @NotBlank(message = "The field cannot be empty or blank.")
    @Getter @Setter
    private String name;

    @NotBlank(message = "The field cannot be empty or blank.")
    @Getter @Setter
    private String description;

    @Positive(message = "This value cannot be negative or equal to zero.")
    @Getter @Setter
    private Double price;

    @Positive(message = "This value cannot be negative or equal to zero.")
    @Getter @Setter
    private Integer quantity;

    @NotNull(message = "This field cannot be null.")
    @Getter @Setter
    private String imgUrl;

    @NotNull(message = "The product must belong to a seller.")
    @Getter @Setter
    private SellerDTO seller;

    @NotEmpty(message = "The product must belong to at least one category.")
    @Getter
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, Integer quantity, String imgUrl, SellerDTO seller) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
        this.seller = seller;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        imgUrl = entity.getImgUrl();
        seller = new SellerDTO(entity.getSeller());
    }

    public ProductDTO(Product entity, Set<Category> categories) {
        this(entity);
        categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
    }

    public ProductDTO(Product entity, UserSeller seller, Set<Category> categories) {
        this(entity);
        this.seller = new SellerDTO(seller);
        categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
    }
}
