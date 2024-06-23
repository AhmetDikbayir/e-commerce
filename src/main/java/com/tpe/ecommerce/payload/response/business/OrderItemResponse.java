package com.tpe.ecommerce.payload.response.business;

import com.tpe.ecommerce.entity.business.Product;
import com.tpe.ecommerce.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderItemResponse {

    private Long id;

    private Integer quantity;

    private Double totalPrice;

    private Product product;

    private User customer;
}
