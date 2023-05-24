package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class UserMinDTO implements Serializable {
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

    public UserMinDTO() {
    }

    public UserMinDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        birthDate = entity.getBirthDate();
        email = entity.getEmail();
    }
}
