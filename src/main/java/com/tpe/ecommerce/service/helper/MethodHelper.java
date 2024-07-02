package com.tpe.ecommerce.service.helper;

import com.tpe.ecommerce.entity.business.Product;
import com.tpe.ecommerce.exceptions.ResourceNotFoundException;
import com.tpe.ecommerce.payload.messages.ErrorMessages;
import com.tpe.ecommerce.repository.business.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MethodHelper {

    private final ProductRepository productRepository;

    public Product isProductExist(Long productId){
        return productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessages.PRODUCT_NOT_FOUND, productId)));
    }

    public Integer isStockBiggerThanOrEqualZero(){
        return null;
    }
}
