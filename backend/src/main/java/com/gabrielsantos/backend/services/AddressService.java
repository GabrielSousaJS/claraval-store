package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.AddressDTO;
import com.gabrielsantos.backend.dto.UserDTO;
import com.gabrielsantos.backend.entities.Address;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address copyDtoToEntityAndSave(UserDTO userDTO) {
        Address entity = new Address();

        entity.setId(userDTO.getAddress().getId());
        entity.setPublicPlace(userDTO.getAddress().getPublicPlace());
        entity.setCep(userDTO.getAddress().getCep());
        entity.setNumber(userDTO.getAddress().getNumber());
        entity.setCity(userDTO.getAddress().getCity());
        entity.setState(userDTO.getAddress().getState());
        entity.setCountry(userDTO.getAddress().getCountry());

        entity = repository.save(entity);

        return entity;
    }

    public void copyDtoToEntityForUpdateAndSave(User entity, AddressDTO dto) {
        entity.getAddress().setPublicPlace(dto.getPublicPlace());
        entity.getAddress().setCep(dto.getCep());
        entity.getAddress().setNumber(dto.getNumber());
        entity.getAddress().setCity(dto.getCity());
        entity.getAddress().setState(dto.getState());
        entity.getAddress().setCountry(dto.getCountry());

        repository.save(entity.getAddress());
    }
}
