package com.gabrielsantos.backend.resources;

import com.gabrielsantos.backend.dto.CategoryDTO;
import com.gabrielsantos.backend.services.CategoryService;
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
@RequestMapping(value = "/api/categories")
@Api(tags = "Category Resource", value = "CategoryResource")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    @ApiOperation(value = "Get categories")
    @ApiResponse(code = 200, message = "Categories found")
    public ResponseEntity<Page<CategoryDTO>> findAllPaged(Pageable pageable) {
        Page<CategoryDTO> page = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Insert category")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Category created"),
            @ApiResponse(code = 401, message = "Unauthorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource")
    })
    public ResponseEntity<CategoryDTO> insert(@Valid @RequestBody CategoryDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Delete category by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted category"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 403, message = "Prohibited action")
    })
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
