package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.CategoryDTO;
import com.gabrielsantos.backend.entities.Category;
import com.gabrielsantos.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(Pageable pageable) {
        Page<Category> page = repository.findAll(pageable);
        return page.map(CategoryDTO::new);
    }
}
