package com.tpe.ecommerce.repository;

import com.tpe.ecommerce.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Boolean existsByEmail(String email);
}
