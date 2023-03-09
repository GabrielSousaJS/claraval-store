package com.gabrielsantos.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_userseller")
public class UserSeller extends User {

    private static final long serialVersionUID = 1L;

    private String companyName;

    @OneToMany(mappedBy = "seller")
    private Set<Product> products = new HashSet<>();

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

    public Set<Product> getProducts() {
        return products;
    }
}
