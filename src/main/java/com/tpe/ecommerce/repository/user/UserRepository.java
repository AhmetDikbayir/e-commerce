package com.tpe.ecommerce.repository.user;

import com.tpe.ecommerce.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name = ?1 AND u.lastName = ?2")
    List<User> findByUserFullName(String name, String lastName);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1")
    List<User> getAllUsersByContainsName(String name);
}
