package com.tpe.ecommerce.service.business;


import com.tpe.ecommerce.entity.business.Product;
import com.tpe.ecommerce.payload.mapper.business.ProductMapper;
import com.tpe.ecommerce.payload.request.business.ProductRequest;
import com.tpe.ecommerce.payload.response.business.ProductResponse;
import com.tpe.ecommerce.repository.business.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public ResponseEntity<ProductResponse> saveProduct(ProductRequest productRequest) {

        //TODO: Do controls before

        Product savedProduct = productMapper.productRequestToProduct(productRequest);

        return (ResponseEntity<ProductResponse>) productRepository.save(savedProduct);

    }
}
