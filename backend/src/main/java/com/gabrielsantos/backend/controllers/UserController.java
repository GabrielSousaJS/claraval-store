package com.gabrielsantos.backend.controllers;

import com.gabrielsantos.backend.dto.*;
import com.gabrielsantos.backend.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/users")
@Api(tags = "User Resource", value = "UserResource")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Get users paged")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users found"),
            @ApiResponse(code = 403, message = "Prohibited action"),
            @ApiResponse(code = 404, message = "Users not found")
    })
    public ResponseEntity<Page<UserMinDTO>> findAllPaged(
            @RequestParam(value = "name", defaultValue = "") String name, Pageable pageable) {
        Page<UserMinDTO> pageDto = service.findAllPaged(name, pageable);
        return ResponseEntity.ok().body(pageDto);
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

    @GetMapping(value = "/sellers")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Get sellers paged")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sellers found"),
            @ApiResponse(code = 403, message = "Prohibited action"),
            @ApiResponse(code = 404, message = "Sellers not found")
    })
    public ResponseEntity<Page<SellerDTO>> findAllSellers(Pageable pageable) {
        Page<SellerDTO> pageDto = service.findAllSellers(pageable);
        return ResponseEntity.ok().body(pageDto);
    }

    @GetMapping(value = "/profile")
    @ApiOperation(value = "Get logged in user information")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User information found"),
            @ApiResponse(code = 401, message = "Unathorized feature")
    })
    public ResponseEntity<UserDTO> getLoggedInUserInformation() {
        UserDTO dto = service.getLoggedInUserInformation();
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

    @PostMapping(value = "/profile/seller")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Insert seller")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Insert seller"),
            @ApiResponse(code = 400, message = "Conflict when making use of the resource"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource"),
            @ApiResponse(code = 412, message = "Precondition not met")
    })
    public ResponseEntity<UserDTO> insertSeller(@Valid @RequestBody UserInsertDTO dto) {
        UserDTO newDto = service.insertSeller(dto);
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