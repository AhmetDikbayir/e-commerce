package com.tpe.ecommerce.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotNull(message = "Product name cannot be null!!")
    @NotEmpty(message = "Product name cannot be empty!!")
    private String productName;

    @NotNull(message = "Brand cannot be null!!")
    @NotEmpty(message = "Brand cannot be empty!!")
    private String brand;

    @NotNull(message = "Price cannot be null!!")
    private Double price;
}