package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Address;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serial;
import java.io.Serializable;

public class AddressDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long id;

    @NotBlank(message = "The field cannot be empty or blank.")
    @Getter @Setter
    private String publicPlace;

    @NotBlank(message = "The field cannot be empty or blank.")
    @Getter @Setter
    private String cep;

    @Positive(message = "The number must be positive other than zero.")
    @Getter @Setter
    private Integer number;

    @NotBlank(message = "The field cannot be empty or blank.")
    @Getter @Setter
    private String city;

    @NotBlank(message = "The field cannot be empty or blank.")
    @Getter @Setter
    private String state;

    public AddressDTO() {
    }

    public AddressDTO(Address entity) {
        id = entity.getId();
        publicPlace = entity.getPublicPlace();
        cep = entity.getCep();
        number = entity.getNumber();
        city = entity.getCity();
        state = entity.getState();
    }
}
