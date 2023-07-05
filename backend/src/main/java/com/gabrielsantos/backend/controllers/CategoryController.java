package com.gabrielsantos.backend.controllers;

import com.gabrielsantos.backend.dto.CategoryDTO;
import com.gabrielsantos.backend.services.CategoryService;
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
@RequestMapping(value = "/api/categories")
@Api(tags = "Category Resource", value = "CategoryResource")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    @ApiOperation(value = "Get categories")
    @ApiResponse(code = 200, message = "Categories found")
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get category by id")
    @ApiResponse(code = 200, message = "Categories found")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        CategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Insert category")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Category created"),
            @ApiResponse(code = 401, message = "Unauthorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource"),
            @ApiResponse(code = 412, message = "Precondition not met")
    })
    public ResponseEntity<CategoryDTO> insert(@Valid @RequestBody CategoryDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Update category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update category"),
            @ApiResponse(code = 401, message = "Unauthorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Delete category by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted category"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 403, message = "Prohibited action"),
            @ApiResponse(code = 404, message = "Category not found"),
    })
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
