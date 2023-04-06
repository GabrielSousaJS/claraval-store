package com.gabrielsantos.backend.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sellers")
public class UserSeller extends User {

    private static final long serialVersionUID = 1L;

    private String companyName;

    @OneToMany(mappedBy = "seller")
    private Set<Product> products = new HashSet<>();

    public UserSeller() {
    }

    public UserSeller(Long id, String name, Instant birthDate, String email, String password, String companyName) {
        super(id, name, birthDate, email, password);
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
