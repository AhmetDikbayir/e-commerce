package com.tpe.ecommerce.repository;

import com.tpe.ecommerce.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
