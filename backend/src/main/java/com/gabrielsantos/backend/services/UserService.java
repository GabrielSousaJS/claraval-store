package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.SellerDTO;
import com.gabrielsantos.backend.dto.UserDTO;
import com.gabrielsantos.backend.dto.UserMinDTO;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.entities.UserSeller;
import com.gabrielsantos.backend.repositories.UserRepository;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public Page<UserMinDTO> findAllPaged(String name, Pageable pageable) {
        Page<User> page = repository.findAllUser(name, pageable);

        if (page.getTotalElements() == 0) {
            throw new ResourceNotFoundException("User '" + name + "' not found.");
        }

        return page.map(UserMinDTO::new);
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("User not found."));
        return new UserDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<SellerDTO> findAllSellers(Pageable pageable) {
        Page<UserSeller> page = repository.findAllSellers(pageable);
        return page.map(SellerDTO::new);
    }

}
