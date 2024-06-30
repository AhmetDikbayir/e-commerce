package com.tpe.ecommerce.payload.mapper.business;

import com.tpe.ecommerce.entity.business.Product;
import com.tpe.ecommerce.payload.request.business.ProductRequest;
import com.tpe.ecommerce.payload.response.business.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse productToProductResponse(Product product){

        return ProductResponse.builder()
                .productName(product.getProductName())
                .brand(product.getBrand())
                .price(product.getPrice())
                .stock(product.getStock())
                .description(product.getDescription())
                .build();
    }

    public Product productRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .productName(productRequest.getProductName())
                .brand(productRequest.getBrand())
                .price(productRequest.getPrice())
                .stock(productRequest.getStock())
                .description(productRequest.getDescription())
                .build();
    }

}
