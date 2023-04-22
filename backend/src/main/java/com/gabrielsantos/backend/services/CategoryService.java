package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.CategoryDTO;
import com.gabrielsantos.backend.entities.Category;
import com.gabrielsantos.backend.repositories.CategoryRepository;
import com.gabrielsantos.backend.services.exceptions.DatabaseException;
import com.gabrielsantos.backend.services.exceptions.DuplicateDataException;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(Pageable pageable) {
        Page<Category> page = repository.findAll(pageable);
        return page.map(CategoryDTO::new);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        if (!categoryExists(dto.getName())) {
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        } else {
            throw new DuplicateDataException("The category is already registered.");
        }
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            repository.save(entity);
            return new CategoryDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Category not found for data update.");
        }
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Category not found.");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("The category cannot be deleted. There are products that belong to her.");
        }
    }

    private boolean categoryExists(String name) {
        Category entity = repository.findByName(name);
        return entity != null;
    }
}
