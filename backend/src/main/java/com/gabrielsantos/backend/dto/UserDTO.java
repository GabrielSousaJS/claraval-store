package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.User;
import lombok.Getter;
import lombok.Setter;

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

    @Getter @Setter
    private Long id;

    @NotBlank(message = "This field cannot be empty or blank.")
    @Getter @Setter
    private String name;

    @Past(message = "The date of birth must be in the past.")
    @Getter @Setter
    private Instant birthDate;

    @Email(message = "Please provide a valid email.")
    @Getter @Setter
    private String email;

    @NotNull(message = "The user must have a registered address.")
    @Getter @Setter
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
}
