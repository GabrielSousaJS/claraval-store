package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.ProductDTO;
import com.gabrielsantos.backend.dto.ProductMinDTO;
import com.gabrielsantos.backend.entities.Product;
import com.gabrielsantos.backend.repositories.ProductRepository;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAllPaged(Pageable pageable) {
        Page<Product> page = repository.findAll(pageable);
        return page.map(ProductMinDTO::new);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return new ProductDTO(entity);
    }
}
