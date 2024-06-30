package com.tpe.ecommerce.service.business;


import com.tpe.ecommerce.entity.business.Product;
import com.tpe.ecommerce.payload.mapper.business.ProductMapper;
import com.tpe.ecommerce.payload.request.business.ProductRequest;
import com.tpe.ecommerce.payload.response.business.ProductResponse;
import com.tpe.ecommerce.repository.business.ProductRepository;
import com.tpe.ecommerce.service.helper.MethodHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final MethodHelper methodHelper;
    public ResponseEntity<ProductResponse> saveProduct(ProductRequest productRequest) {

        //TODO: Do controls before

        Product savedProduct = productMapper.productRequestToProduct(productRequest);
        productRepository.save(savedProduct);

        return ResponseEntity.ok(productMapper.productToProductResponse(savedProduct));

    }

    public ResponseEntity<ProductResponse> getProductById(Long productId) {
        Product foundProduct = methodHelper.isProductExist(productId);
        return ResponseEntity.ok(productMapper.productToProductResponse(foundProduct));
    }

    public ResponseEntity<String> deleteProductById(Long productId) {
    }
}
