package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.services.validation.SellerInsertValid;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@SellerInsertValid
public class SellerInsertDTO extends UserDTO {

    @NotBlank(message = "This field cannot be empty or blank.")
    @Getter @Setter
    private String password;

    @NotBlank(message = "This field cannot be empty or blank.")
    @Getter @Setter
    private String companyName;

    public SellerInsertDTO() {
        super();
    }
}
