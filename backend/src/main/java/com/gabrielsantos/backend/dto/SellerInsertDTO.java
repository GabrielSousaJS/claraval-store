package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.services.validation.SellerInsertValid;

import javax.validation.constraints.NotBlank;

@SellerInsertValid
public class SellerInsertDTO extends UserDTO {

    @NotBlank(message = "This field cannot be empty or blank.")
    private String password;

    @NotBlank(message = "This field cannot be empty or blank.")
    private String companyName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
