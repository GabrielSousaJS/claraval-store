package com.gabrielsantos.backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table
public class Registry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String action;
    @Getter @Setter
    private String verbHttp;
    @Getter @Setter
    private String userLogged;
    @Getter @Setter
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    public Registry() {
    }

    public Registry(String action, String verbHttp, String userLogged, Instant moment) {
        this.action = action;
        this.verbHttp = verbHttp;
        this.userLogged = userLogged;
        this.moment = moment;
    }

    public Registry(Long id, String action, String verbHttp, String userLogged, Instant moment) {
        this.id = id;
        this.action = action;
        this.verbHttp = verbHttp;
        this.userLogged = userLogged;
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registry registry = (Registry) o;
        return Objects.equals(id, registry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}