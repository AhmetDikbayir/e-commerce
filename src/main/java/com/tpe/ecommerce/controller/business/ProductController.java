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
    //@PreAuthorize("ADMIN")
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }

    @GetMapping("/{productId}")  //http://localhost:8080/products/1
    //@PreAuthoritize("ADMIN")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }



}
