package com.tpe.ecommerce.payload.request.business;

import com.tpe.ecommerce.entity.business.Product;
import com.tpe.ecommerce.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderItemRequest {

    @NotNull(message = "Please enter a valid quantity")
    private Integer quantity;

    @NotNull(message = "Total price cannot be null!")
    private Double totalPrice;

    @NotNull(message = "Please enter a product")
    private Product product;

    @NotNull(message = "Customer field cannot be null")
    private User customer;
}
