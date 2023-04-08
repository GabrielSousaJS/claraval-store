package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serial;
import java.io.Serializable;

public class AddressDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "The field cannot be empty or blank.")
    private String publicPlace;

    @NotBlank(message = "The field cannot be empty or blank.")
    private String cep;

    @Positive(message = "The number must be positive other than zero.")
    private Integer number;

    @NotBlank(message = "The field cannot be empty or blank.")
    private String city;

    @NotBlank(message = "The field cannot be empty or blank.")
    private String state;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String publicPlace, String cep, Integer number, String city, String state) {
        this.id = id;
        this.publicPlace = publicPlace;
        this.cep = cep;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public AddressDTO(Address entity) {
        id = entity.getId();
        publicPlace = entity.getPublicPlace();
        cep = entity.getCep();
        number = entity.getNumber();
        city = entity.getCity();
        state = entity.getState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
