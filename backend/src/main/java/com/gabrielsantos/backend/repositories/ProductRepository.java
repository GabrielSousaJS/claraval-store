package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.Category;
import com.gabrielsantos.backend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT obj FROM Product obj INNER JOIN obj.categories cats " +
            "WHERE (cats IN :category)")
    Page<Product> findProductsByCategory(Category category, Pageable pageable);

}
