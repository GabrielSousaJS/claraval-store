package com.gabrielsantos.backend.controllers;

import com.gabrielsantos.backend.dto.AddressDTO;
import com.gabrielsantos.backend.dto.UserDTO;
import com.gabrielsantos.backend.dto.UserInsertDTO;
import com.gabrielsantos.backend.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "User Resource", value = "UserResource")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Get users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users found"),
            @ApiResponse(code = 403, message = "Prohibited action"),
            @ApiResponse(code = 404, message = "Users not found")
    })
    public ResponseEntity<List<UserDTO>> findAll(
            @RequestParam(value = "name", defaultValue = "") String name) {
        List<UserDTO> listDto = service.findAll(name);
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Get user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 403, message = "Prohibited action"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @ApiOperation(value = "Insert client")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 400, message = "Conflict when making use of the resource"),
            @ApiResponse(code = 412, message = "Precondition not met")
    })
    public ResponseEntity<UserDTO> insertClient(@Valid @RequestBody UserInsertDTO dto) {
        UserDTO newDto = service.insertClient(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/update-personal-information")
    @ApiOperation(value = "Update personal information")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update personal information"),
            @ApiResponse(code = 412, message = "Precondition not met")
    })
    public ResponseEntity<UserDTO> updatePersonalInformation(@Valid @RequestBody UserInsertDTO dto) {
        UserDTO newDto = service.updatePersonalInformation(dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PutMapping(value = "/update-address")
    @ApiOperation(value = "Update address")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update address"),
            @ApiResponse(code = 412, message = "Precondition not met")
    })
    public ResponseEntity<UserDTO> updateAddressUser(@Valid @RequestBody AddressDTO dto) {
        UserDTO userDTO = service.updateUserAddress(dto);
        return ResponseEntity.ok().body(userDTO);
    }
}