package com.gabrielsantos.backend.controllers;

import com.gabrielsantos.backend.dto.ProductDTO;
import com.gabrielsantos.backend.services.ProductService;
import com.gabrielsantos.backend.services.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private RegistryService registryService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(
            @RequestParam(value = "name", defaultValue = "") String name
    ) {
        List<ProductDTO> listDto = service.findAll(name);
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/filtercategory/{categoryId}")
    public ResponseEntity<List<ProductDTO>> findProductsByCategory(
            @PathVariable Long categoryId,
            @RequestParam(value = "name", defaultValue = "") String name
    ) {
        List<ProductDTO> listDto = service.findProductsByCategory(categoryId, name);
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        registryService.registryAction("Adicionando um produto", "POST");
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        ProductDTO newDto = service.update(id, dto);
        registryService.registryAction("Atualizando um produto", "PUT");
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id) {
        service.DeleteById(id);

        registryService.registryAction("Apagando um produto", "DELETE");
        return ResponseEntity.noContent().build();
    }
}
