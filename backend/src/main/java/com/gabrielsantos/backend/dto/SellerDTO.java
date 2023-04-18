package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.UserSeller;
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

    @Email(message = "Please provide a valid email.")
    @Getter @Setter
    private String email;

    @NotBlank(message = "This field cannot be empty or blank.")
    @Getter @Setter
    private String companyName;

    public SellerDTO() {
    }

    public SellerDTO(Long id, String email, String companyName) {
        this.id = id;
        this.email = email;
        this.companyName = companyName;
    }

    public SellerDTO(UserSeller entity) {
        id = entity.getId();
        email = entity.getEmail();
        companyName = entity.getCompanyName();
    }
}
