package com.tpe.ecommerce.payload.request.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductRequest {

    @NotNull(message = "Brand cannot be null!!")
    @NotEmpty(message = "Brand cannot be empty!!")
    private String productName;

    @NotNull(message = "Brand cannot be null!!")
    @NotEmpty(message = "Brand cannot be empty!!")
    private String brand;

    private String Description;

    @NotNull(message = "Stock cannot be null")
    private Integer stock;

    @NotNull(message = "Price cannot be null!!")
    private Double price;
}
