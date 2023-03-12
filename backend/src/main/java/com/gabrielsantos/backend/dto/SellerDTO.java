package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.UserSeller;

import java.io.Serial;
import java.io.Serializable;

public class SellerDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
