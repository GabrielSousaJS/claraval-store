package com.gabrielsantos.backend.controllers;

import com.gabrielsantos.backend.dto.AddressDTO;
import com.gabrielsantos.backend.dto.UserDTO;
import com.gabrielsantos.backend.dto.UserInsertDTO;
import com.gabrielsantos.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> findAll(
            @RequestParam(value = "name", defaultValue = "") String name) {
        List<UserDTO> listDto = service.findAll(name);
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insertClient(@Valid @RequestBody UserInsertDTO dto) {
        UserDTO newDto = service.insertClient(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/update-personal-information")
    public ResponseEntity<UserDTO> updatePersonalInformation(@Valid @RequestBody UserInsertDTO dto) {
        UserDTO newDto = service.updatePersonalInformation(dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PutMapping(value = "/update-address")
    public ResponseEntity<UserDTO> updateAddressUser(@Valid @RequestBody AddressDTO dto) {
        UserDTO userDTO = service.updateUserAddress(dto);
        return ResponseEntity.ok().body(userDTO);
    }
}