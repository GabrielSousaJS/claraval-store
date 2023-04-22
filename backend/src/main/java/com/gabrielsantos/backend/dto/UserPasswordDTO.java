package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.services.validation.UserInsertValid;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@UserInsertValid
public class UserPasswordDTO extends UserDTO {

    @NotBlank(message = "This field cannot be empty or blank.")
    @Getter @Setter
    private String password;

    public UserPasswordDTO() {
        super();
    }
}
