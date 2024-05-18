package com.tpe.ecommerce.domain;

import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "Please enter a valid quantity")
    @Column(nullable = false)
    private Integer quantity;

    @NotNull
    private Double totalPrice;

    @NotNull(message = "Please enter a product")
    @ManyToOne
    private Product product;
    @NotNull
    @ManyToOne
    private Customer customer;
}
