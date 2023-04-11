package com.gabrielsantos.backend.dto;

import javax.validation.constraints.NotBlank;

public class UserInsertDTO extends UserDTO {

    @NotBlank(message = "This field cannot be empty or blank.")
    private String password;

    public UserInsertDTO() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
