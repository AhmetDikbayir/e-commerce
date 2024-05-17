package com.tpe.ecommerce.domain;

import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    private Customer customer;
}
