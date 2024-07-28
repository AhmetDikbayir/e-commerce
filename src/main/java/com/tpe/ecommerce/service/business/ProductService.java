package com.tpe.ecommerce.service.business;


import com.tpe.ecommerce.entity.business.Product;
import com.tpe.ecommerce.exceptions.BadRequestException;
import com.tpe.ecommerce.payload.mapper.business.ProductMapper;
import com.tpe.ecommerce.payload.messages.ErrorMessages;
import com.tpe.ecommerce.payload.request.business.ProductRequest;
import com.tpe.ecommerce.payload.response.business.ProductResponse;
import com.tpe.ecommerce.repository.business.ProductRepository;
import com.tpe.ecommerce.service.helper.MethodHelper;
import com.tpe.ecommerce.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final MethodHelper methodHelper;
    private final PageableHelper pageableHelper;

    public ResponseEntity<ProductResponse> saveProduct(ProductRequest productRequest) {

        //stock should not be negative
        if(productRequest.getStock()<0){
            throw new BadRequestException(ErrorMessages.PRODUCT_STOCK_SHOULD_BIGGER_ZERO);
        }

        //price should bigger than zero
        if(productRequest.getPrice()<=0){
            throw new BadRequestException(ErrorMessages.PRODUCT_PRICE_SHOULD_BIGGER_ZERO);
        }

        //productName should be unique
        for(Product product: productRepository.findAll()){
            if(product.getProductName().equalsIgnoreCase(productRequest.getProductName())){
                throw new BadRequestException(ErrorMessages.PRODUCT_ALREADY_EXIST);
            }
        }

        Product savedProduct = productMapper.productRequestToProduct(productRequest);
        productRepository.save(savedProduct);

        return ResponseEntity.ok(productMapper.productToProductResponse(savedProduct));
    }
    public ResponseEntity<ProductResponse> getProductById(Long productId) {
        Product foundProduct = methodHelper.isProductExist(productId);
        return ResponseEntity.ok(productMapper.productToProductResponse(foundProduct));
    }
    public ResponseEntity<ProductResponse> deleteProductById(Long productId) {

        Product deletedProduct = methodHelper.isProductExist(productId);
        productRepository.delete(deletedProduct);
        return ResponseEntity.ok(productMapper.productToProductResponse(deletedProduct));
    }

    public ResponseEntity<ProductResponse> updateProductPrice(Long productId, ProductRequest productRequest) {
        methodHelper.isProductExist(productId);
        //TODO: Product id should map in mapper
        Product updatedProduct = productMapper.productRequestToProduct(productRequest);
        productRepository.save(updatedProduct);
        return ResponseEntity.ok(productMapper.productToProductResponse(updatedProduct));
    }

    public Page<ProductResponse> findProductByPage(int page, int size, String sort, String type) {
        Pageable pageable = pageableHelper.getPageableWithProperties(page, size, sort, type);
        return productRepository.findAll(pageable).map(productMapper:: productToProductResponse);
    }
}
