package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Address;
import com.gabrielsantos.backend.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "This field cannot be empty or blank.")
    private String name;

    @Past(message = "The date of birth must be in the past.")
    private Instant birthDate;

    @Email(message = "Please provide a valid email.")
    private String email;

    @NotNull(message = "The user must have a registered address.")
    private AddressDTO address;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, Instant birthDate, String email, AddressDTO address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        birthDate = entity.getBirthDate();
        email = entity.getEmail();
        address = new AddressDTO(entity.getAddress());
    }

    public UserDTO(User entity, Address address) {
        id = entity.getId();
        name = entity.getName();
        birthDate = entity.getBirthDate();
        email = entity.getEmail();
        this.address = new AddressDTO(address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
