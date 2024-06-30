package com.tpe.ecommerce.controller.business;

import com.tpe.ecommerce.payload.request.business.ProductRequest;
import com.tpe.ecommerce.payload.response.business.ProductResponse;
import com.tpe.ecommerce.service.business.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")  //http:localhost://8080/products/save
    //@PreAuthorize("hasAnyAuthority('ADMIN','SELLER)")
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }
    @GetMapping("/{productId}")  //http://localhost:8080/products/1 +GET
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @DeleteMapping("/{productId}") //http://localhost:8080/products/2 +DELETE
    //@PreAuthorize("hasAnyAuthority('ADMIN','SELLER')")
    public ResponseEntity<ProductResponse> deleteProductById(@PathVariable Long productId){
        return productService.deleteProductById(productId);
    }

    @PutMapping("/{productId}")
    //@PreAuthorize("hasAnyAuthority('ADMIN','SELLER')")
    public ResponseEntity<ProductResponse> updateProductPrice(@PathVariable Long productId, @RequestBody ProductRequest productRequest){
        return productService.increaseProductPrice(productId, productRequest);
    }




}
