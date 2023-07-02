package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

public class CategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long id;

    @NotBlank(message = "O campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
