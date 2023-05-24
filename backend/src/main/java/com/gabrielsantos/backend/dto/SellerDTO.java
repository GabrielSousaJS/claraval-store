package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

public class SellerDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long id;

    @NotBlank(message = "This field cannot be empty or blank.")
    @Getter @Setter
    private String name;

    @Email(message = "Please provide a valid email.")
    @Getter @Setter
    private String email;

    public SellerDTO() {
    }

    public SellerDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }
}
