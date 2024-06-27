package com.tpe.ecommerce.repository.business;

import com.tpe.ecommerce.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
}
