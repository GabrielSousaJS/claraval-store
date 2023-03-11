package com.gabrielsantos.backend.repositories;

import com.gabrielsantos.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
