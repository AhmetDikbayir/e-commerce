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

    @Column(nullable = false, unique = true)
    private String productName;

    @Column(nullable = false)
    private String brand;

    private String description;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Double price;
}
