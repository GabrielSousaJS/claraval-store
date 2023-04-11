package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.UserDTO;
import com.gabrielsantos.backend.entities.Address;
import com.gabrielsantos.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address copyDtoToEntity(UserDTO userDTO) {
        Address entity = new Address();

        entity.setId(userDTO.getAddress().getId());
        entity.setPublicPlace(userDTO.getAddress().getPublicPlace());
        entity.setCep(userDTO.getAddress().getCep());
        entity.setNumber(userDTO.getAddress().getNumber());
        entity.setCity(userDTO.getAddress().getCity());
        entity.setState(userDTO.getAddress().getState());

        entity = repository.save(entity);

        return entity;
    }

}
