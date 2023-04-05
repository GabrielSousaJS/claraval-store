package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.ProductDTO;
import com.gabrielsantos.backend.dto.ProductMinDTO;
import com.gabrielsantos.backend.entities.Category;
import com.gabrielsantos.backend.entities.Product;
import com.gabrielsantos.backend.entities.UserSeller;
import com.gabrielsantos.backend.repositories.CategoryRepository;
import com.gabrielsantos.backend.repositories.ProductRepository;
import com.gabrielsantos.backend.repositories.UserRepository;
import com.gabrielsantos.backend.services.exceptions.DatabaseException;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAllPaged(String name, Pageable pageable) {
        Page<Product> page = repository.findAllPaged(name, pageable);

        if (page.getTotalElements() == 0) {
            throw new ResourceNotFoundException("Product '" + name + "' not found.");
        }

        return page.map(ProductMinDTO::new);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Product not found."));
        return new ProductDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findProductsByCategory(Long categoryId, Pageable pageable) {
        Category category = categoryRepository.getReferenceById(categoryId);
        Page<Product> page = repository.findProductsByCategory(category, pageable);

        if (page.getTotalElements() == 0) {
            throw new ResourceNotFoundException("No products belong to this category.");
        }

        return page.map(ProductMinDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findProductsBySeller(Long sellerId, Pageable pageable) {
        Page<Product> page = repository.findProductsBySeller(sellerId, pageable);

        if (page.getTotalElements() == 0) {
            throw new ResourceNotFoundException("There is no product listed for this seller.");
        }

        return page.map(ProductMinDTO::new);
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return new ProductDTO(entity, entity.getCategories());
    }

    public void DeleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integraty violation");
        }
    }

    private void copyDtoToEntity(Product entity, ProductDTO dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setImgUrl(dto.getImgUrl());
        entity.setSeller((UserSeller) userRepository.getReferenceById(dto.getSeller().getId()));
        dto.getCategories().stream().map(cat -> entity.getCategories().add(categoryRepository.getReferenceById(cat.getId()))).collect(Collectors.toList());
    }
}
