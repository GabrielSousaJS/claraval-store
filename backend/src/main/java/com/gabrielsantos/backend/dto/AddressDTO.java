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

    @NotBlank(message = "O campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String publicPlace;

    @NotBlank(message = "O campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String cep;

    @Positive(message = "O número deve ser positivo diferente de zero")
    @Getter @Setter
    private Integer number;

    @NotBlank(message = "O campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String city;

    @NotBlank(message = "O campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String state;

    @NotBlank(message = "O campo não pode estar vazio ou em branco")
    @Getter @Setter
    private String country;

    public AddressDTO() {
    }

    public AddressDTO(Address entity) {
        id = entity.getId();
        publicPlace = entity.getPublicPlace();
        cep = entity.getCep();
        number = entity.getNumber();
        city = entity.getCity();
        state = entity.getState();
        country = entity.getCountry();
    }
}
