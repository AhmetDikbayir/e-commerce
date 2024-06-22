package com.tpe.ecommerce.payload.response;

import com.tpe.ecommerce.entity.business.Product;
import com.tpe.ecommerce.entity.user.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderItemResponse {

    private Long id;

    private Integer quantity;

    private Double totalPrice;

    private Product product;

    private Customer customer;
}
