package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.UserDTO;
import com.gabrielsantos.backend.dto.UserInsertDTO;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.repositories.UserRepository;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    private PrivilegeService privilegeService;

    @Autowired
    private AddressService addressService;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(String name) {
        List<User> list = repository.findAllUser(name);
        return list.stream().map(UserDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insertClient(UserInsertDTO dto) {
        User client = new User();
        copyDtoToEntityUser(client, dto);
        addPrivilegeClient(client);
        client.setPassword(passwordEncoder.encode(dto.getPassword()));
        client = repository.save(client);
        return new UserDTO(client);
    }

    @Transactional
    public UserDTO insertAdmin(UserInsertDTO dto) {
        User admin = new User();
        copyDtoToEntityUser(admin, dto);
        addPrivilegeAdmin(admin);
        addPrivilegeClient(admin);
        admin.setPassword(passwordEncoder.encode(dto.getPassword()));
        admin = repository.save(admin);
        return new UserDTO(admin);
    }

    private void copyDtoToEntityUser(User user, UserDTO dto) {
        user.setName(dto.getName());
        user.setBirthDate(dto.getBirthDate());
        user.setEmail(dto.getEmail());
        user.setAddress(addressService.copyDtoToEntityAndSave(dto));
    }

    private void addPrivilegeClient(User entity) {
        privilegeService.insertClientPrivilege(entity);
    }

    private void addPrivilegeAdmin(User entity) {
        privilegeService.insertAdminPrivilege(entity);
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
