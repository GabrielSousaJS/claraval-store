package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.*;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.entities.UserSeller;
import com.gabrielsantos.backend.repositories.UserRepository;
import com.gabrielsantos.backend.repositories.UserSellerRepository;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserSellerRepository sellerRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private AddressService addressService;

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

    @Transactional(readOnly = true)
    public UserDTO getUserLogged() {
        User entity = authService.authenticated();
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insertClient(UserPasswordDTO dto) {
        User client = new User();
        copyDtoToEntityUser(client, dto);
        addPrivilegeClient(client);
        client.setPassword(passwordEncoder.encode(dto.getPassword()));
        client = repository.save(client);
        return new UserDTO(client);
    }

    @Transactional
    public SellerDTO insertSeller(SellerInsertDTO dto) {
        UserSeller seller = new UserSeller();
        copyDtoToEntitySeller(seller, dto);
        addPrivilegeSellerAndClient(seller);
        seller.setPassword(passwordEncoder.encode(dto.getPassword()));
        seller = sellerRepository.save(seller);
        return new SellerDTO(seller);
    }

    @Transactional
    public UserDTO updatePersonalInformation(UserPasswordDTO dto) {
        User entity = authService.authenticated();
        copyDtoToEntityForUpdate(entity, dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        repository.save(entity);
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO updateUserAddress(AddressDTO dto) {
        User entity = authService.authenticated();
        addressService.copyDtoToEntityForUpdateAndSave(entity, dto);
        repository.save(entity);
        return new UserDTO(entity);
    }

    private void copyDtoToEntityUser(User client, UserDTO dto) {
        client.setName(dto.getName());
        client.setBirthDate(dto.getBirthDate());
        client.setEmail(dto.getEmail());
        client.setAddress(addressService.copyDtoToEntityAndSave(dto));
    }

    private void copyDtoToEntitySeller(UserSeller seller, SellerInsertDTO dto) {
        seller.setName(dto.getName());
        seller.setBirthDate(dto.getBirthDate());
        seller.setEmail(dto.getEmail());
        seller.setAddress(addressService.copyDtoToEntityAndSave(dto));
        seller.setCompanyName(dto.getCompanyName());
    }

    private void copyDtoToEntityForUpdate(User entity, UserPasswordDTO dto) {
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
    }

    private void addPrivilegeClient(User entity) {
        privilegeService.insertClientPrivilege(entity);
    }

    private void addPrivilegeSellerAndClient(UserSeller entity) {
        privilegeService.insertClientPrivilege(entity);
        privilegeService.insertSellerPrivilege(entity);
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
