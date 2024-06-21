package com.tpe.ecommerce.entity.business;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "Product name cannot be null!!")
    @NotEmpty(message = "Product name cannot be empty!!")
    @Column(nullable = false, unique = true)
    private String productName;

    @NotNull(message = "Brand cannot be null!!")
    @NotEmpty(message = "Brand cannot be empty!!")
    @Column(nullable = false)
    private String brand;

    @NotNull(message = "Price cannot be null!!")
    @Column(nullable = false)
    private Double price;
}
