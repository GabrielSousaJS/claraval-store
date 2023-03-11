package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.ProductMinDTO;
import com.gabrielsantos.backend.entities.Product;
import com.gabrielsantos.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAllPaged(Pageable pageable) {
        Page<Product> page = repository.findAll(pageable);
        return page.map(ProductMinDTO::new);
    }
}
