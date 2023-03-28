package com.gabrielsantos.backend.resources;

import com.gabrielsantos.backend.dto.SellerDTO;
import com.gabrielsantos.backend.dto.UserDTO;
import com.gabrielsantos.backend.dto.UserMinDTO;
import com.gabrielsantos.backend.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
@Api(tags = "User Resource", value = "UserResource")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
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

}
