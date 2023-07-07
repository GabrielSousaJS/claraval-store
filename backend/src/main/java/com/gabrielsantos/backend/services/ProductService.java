package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.CategoryDTO;
import com.gabrielsantos.backend.dto.ProductDTO;
import com.gabrielsantos.backend.entities.Category;
import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.entities.Product;
import com.gabrielsantos.backend.repositories.CategoryRepository;
import com.gabrielsantos.backend.repositories.ProductRepository;
import com.gabrielsantos.backend.services.exceptions.DatabaseException;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(String name) {
        List<Product> list = repository.findAllAndName(name);
        return list.stream().map(product -> new ProductDTO(product, product.getCategories())).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findProductsByCategory(Long categoryId, String name) {
        Category category = categoryRepository.getReferenceById(categoryId);
        List<Product> list = repository.findProductsByCategory(category, name);
        return list.stream().map(product -> new ProductDTO(product, product.getCategories())).toList();
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();

        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(entity, dto);
            repository.save(entity);
            return new ProductDTO(entity, entity.getCategories());
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Produto não encontrado para atualização");
        }

    }

    public void DeleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Produto não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar o pedido, ele está em um pedido já realizado");
        }
    }

    private void copyDtoToEntity(Product entity, ProductDTO dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setImgUrl(dto.getImgUrl());

        entity.getCategories().clear();

        for (CategoryDTO catDto : dto.getCategories()) {
            Category category = categoryRepository.getReferenceById(catDto.getId());
            entity.getCategories().add(category);
        }

    }

    public void updateQuantity(Set<OrderItem> items) {
        for (OrderItem item : items) {
            Integer newQuantity = item.getProduct().getQuantity() - item.getQuantity();
            ProductDTO dto = new ProductDTO(item.getProduct(), item.getProduct().getCategories());
            dto.setQuantity(newQuantity);
            update(item.getProduct().getId(), dto);
        }
    }
}
