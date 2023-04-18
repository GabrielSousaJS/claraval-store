package com.gabrielsantos.backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
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

    @Column(unique = true)
    @Getter @Setter
    private String companyName;

    @OneToMany(mappedBy = "seller")
    @Getter
    private Set<Product> products = new HashSet<>();

    public UserSeller() {
    }

    public UserSeller(Long id, String name, Instant birthDate, String email, String password, String companyName) {
        super(id, name, birthDate, email, password);
        this.companyName = companyName;
    }
}
