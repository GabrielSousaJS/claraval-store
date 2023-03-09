package com.gabrielsantos.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "tb_userseller")
public class UserSeller extends User {

    private static final long serialVersionUID = 1L;

    private String companyName;

    public UserSeller() {
    }

    public UserSeller(Long id, String firstname, String lastname, Instant birthDate, String email, String password, String companyName) {
        super(id, firstname, lastname, birthDate, email, password);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
