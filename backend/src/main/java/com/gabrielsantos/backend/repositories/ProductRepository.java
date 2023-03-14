package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tb_product INNER JOIN tb_product_category " +
            "ON (tb_product.id = tb_product_category.product_id) " +
            "WHERE (tb_product_category.category_id = :categoryId)")
    Page<Product> findProductsByCategory(Long categoryId, Pageable pageable);

}
