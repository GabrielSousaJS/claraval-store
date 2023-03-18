package com.gabrielsantos.backend.resources;

import com.gabrielsantos.backend.dto.ProductDTO;
import com.gabrielsantos.backend.dto.ProductMinDTO;
import com.gabrielsantos.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductMinDTO>> findAllPaged(
            @RequestParam(value = "name", defaultValue = "") String name, Pageable pageable) {
        Page<ProductMinDTO> pageDto = service.findAllPaged(name.trim(), pageable);
        return ResponseEntity.ok().body(pageDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{categoryId}/filtercategory")
    public ResponseEntity<Page<ProductMinDTO>> findProductsByCategory(@PathVariable Long categoryId, Pageable pageable) {
        Page<ProductMinDTO> pageDto = service.findProductsByCategory(categoryId, pageable);
        return ResponseEntity.ok().body(pageDto);
    }
}
