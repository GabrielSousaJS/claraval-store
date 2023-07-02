package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Category;
import com.gabrielsantos.backend.entities.Product;
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

    @NotBlank(message = "Este campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String name;

    @NotBlank(message = "Este campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String description;

    @Positive(message = "Este valor não pode ser negativo ou igual a zero")
    @Getter @Setter
    private Double price;

    @Positive(message = "Este valor não pode ser negativo ou igual a zero")
    @Getter @Setter
    private Integer quantity;

    @NotNull(message = "Este campo não pode ficar vazio")
    @Getter @Setter
    private String imgUrl;

    @NotEmpty(message = "O produto necessita de ao menos uma categoria")
    @Getter
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        imgUrl = entity.getImgUrl();
    }

    public ProductDTO(Product entity, Set<Category> categories) {
        this(entity);
        categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
    }
}
