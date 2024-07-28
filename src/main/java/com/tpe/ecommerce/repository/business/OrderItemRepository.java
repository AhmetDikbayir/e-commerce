package com.tpe.ecommerce.repository.business;

import com.tpe.ecommerce.entity.business.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Item, Long> {
}
