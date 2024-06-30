package com.tpe.ecommerce.repository.business;

import com.tpe.ecommerce.entity.business.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
