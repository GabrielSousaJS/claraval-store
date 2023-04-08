package com.gabrielsantos.backend.resources;

import com.gabrielsantos.backend.dto.ProductDTO;
import com.gabrielsantos.backend.dto.ProductMinDTO;
import com.gabrielsantos.backend.services.ProductService;
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
@RequestMapping(value = "/api/products")
@Api(tags = "Product Resource", value = "ProductResource")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    @ApiOperation(value = "Get products paged")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Products found"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    public ResponseEntity<Page<ProductMinDTO>> findAllPaged(
            @RequestParam(value = "name", defaultValue = "") String name, Pageable pageable) {
        Page<ProductMinDTO> pageDto = service.findAllPaged(name.trim(), pageable);
        return ResponseEntity.ok().body(pageDto);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get product by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product found"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{categoryId}/filtercategory")
    @ApiOperation(value = "Get products from category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category products found"),
            @ApiResponse(code = 404, message = "Category products not found")
    })
    public ResponseEntity<Page<ProductMinDTO>> findProductsByCategory(@PathVariable Long categoryId, Pageable pageable) {
        Page<ProductMinDTO> pageDto = service.findProductsByCategory(categoryId, pageable);
        return ResponseEntity.ok().body(pageDto);
    }

    @GetMapping(value = "/{sellerId}/all-products-from-seller")
    @ApiOperation(value = "Seller products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Seller products found"),
            @ApiResponse(code = 404, message = "Seller products not found")
    })
    public ResponseEntity<Page<ProductMinDTO>> findProductsBySeller(@PathVariable Long sellerId, Pageable pageable) {
        Page<ProductMinDTO> pageDto = service.findProductsBySeller(sellerId, pageable);
        return ResponseEntity.ok().body(pageDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('SELLER')")
    @ApiOperation(value = "Insert product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product created"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource")
    })
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Delete product")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted product"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 403, message = "Prohibited action")
    })
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id) {
        service.DeleteById(id);
        return ResponseEntity.noContent().build();
    }
}
