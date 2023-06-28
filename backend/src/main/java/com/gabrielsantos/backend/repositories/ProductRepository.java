package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.Category;
import com.gabrielsantos.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    @Query("SELECT obj FROM Product obj " +
            "WHERE :name = '' OR LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> findAllAndName(String name);

    @Query("SELECT obj FROM Product obj INNER JOIN obj.categories cats " +
            "WHERE (cats IN :category)")
    List<Product> findProductsByCategory(Category category);
}
