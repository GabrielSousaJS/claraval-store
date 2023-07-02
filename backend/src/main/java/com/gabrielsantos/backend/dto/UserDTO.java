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

    @NotBlank(message = "Este campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String name;

    @Past(message = "A data de nascimento não pode ser futura")
    @Getter @Setter
    private Instant birthDate;

    @Email(message = "Por favor forneça um email válido")
    @Getter @Setter
    private String email;

    @Getter @Setter
    private AddressDTO address;

    public UserDTO() {
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        birthDate = entity.getBirthDate();
        email = entity.getEmail();
        address = new AddressDTO(entity.getAddress());
    }
}
