package com.tpe.ecommerce.repository.business;

import com.tpe.ecommerce.entity.business.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
