package com.tpe.ecommerce.domain.business;

import com.tpe.ecommerce.domain.business.Product;
import com.tpe.ecommerce.domain.user.Customer;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
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
