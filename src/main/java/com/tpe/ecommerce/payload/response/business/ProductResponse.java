package com.tpe.ecommerce.payload.response.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductResponse {

    private Long id;

    private String productName;

    private String brand;

    private String description;

    private Integer stock;

    private Double price;
}
