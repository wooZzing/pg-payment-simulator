package com.pg.merchantserver.domain.product.repository;

import com.pg.merchantserver.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}