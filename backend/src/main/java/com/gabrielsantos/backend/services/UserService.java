package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.SellerDTO;
import com.gabrielsantos.backend.dto.UserDTO;
import com.gabrielsantos.backend.dto.UserMinDTO;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.entities.UserSeller;
import com.gabrielsantos.backend.repositories.UserRepository;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);

        if (user.equals(null)) {
            logger.error("Email not found " + username);
            throw new UsernameNotFoundException("Email not found");
        } else {
            logger.info("Email found " + username);
            return user;
        }
    }
}
