package com.tpe.ecommerce.repository.business;

import com.tpe.ecommerce.entity.business.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long>{
}
